package com.example.crowdmeterproject.view;

import android.accessibilityservice.AccessibilityService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.crowdmeterproject.databinding.AddRatingFragmentBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import com.example.crowdmeterproject.model.Rating;
import com.example.crowdmeterproject.R;



public class AddRatingFragment extends Fragment implements IAddRatingsView {

    AddRatingFragmentBinding binding; // will call the widgets (xml)
    Listener listener; // like the controller --> will recognize when button is clicked etc
    public AddRatingFragment(@NonNull Listener listener)
    {
        this.listener = listener;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = AddRatingFragmentBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // register add button click listener so you know when you press the button - made interactive
        this.binding.addRatingToLocButton.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when associated button is clicked.
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {

                // retrieves location name
                final Editable commentEnteredEditable = AddRatingFragment.this.binding.commentText.getText();
                final String commentString = commentEnteredEditable.toString();

                // retrieve rating number
                final Editable ratingNumberEditable = AddRatingFragment.this.binding.ratingNumberEntered.getText();
                final String ratingNumberString = ratingNumberEditable.toString();

                // confirm we have rating number (comment doesnt matter)
                if (ratingNumberString.length() == 0){
                    String errMsgStr = v.getContext().getString(R.string.missing_fields_error);
                    Snackbar.make(v, errMsgStr, Snackbar.LENGTH_LONG).show();
                    return;
                }

                // won't throw exception because the input field only accepts numbers
                int ratingNumber = Integer.parseInt(ratingNumberString);


                // notify listener (controller) and add rating //two versions in case comment or not
                if (commentEnteredEditable != null || !(commentEnteredEditable.equals(""))) {
                    AddRatingFragment.this.listener.addCommentRatingToLoc(commentString, ratingNumber,
                            AddRatingFragment.this);
                }
                else {
                    AddRatingFragment.this.listener.addRatingToLoc(ratingNumber,
                            AddRatingFragment.this);

                }

                // inform user that rating was successfully added
                Snackbar.make(v, String.format("Successfully added rating of %d to location", ratingNumber), Snackbar.LENGTH_LONG).show();

                // clear the input fields to ready them for the next item
                commentEnteredEditable.clear();
                ratingNumberEditable.clear();
            }
        });
    }

    /**
     * Update display to reflect contents of the rating passed as an argument.
     * @param rating the rating that was just made -> to be displayed
     */
    @Override
    public void updateRatingDisplay(Rating rating) {
        this.binding.ratingNumberEntered.setText(rating.toString());
    }


}



