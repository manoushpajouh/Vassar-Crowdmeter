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
    int selectedRating;
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
        this.binding.ratingButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedRating = 1;
                Snackbar.make(v, String.format("Selected rating of %d", selectedRating), Snackbar.LENGTH_LONG).show();
            }
        }
        );

        this.binding.ratingButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedRating = 2;
                Snackbar.make(v, String.format("Selected rating of %d", selectedRating), Snackbar.LENGTH_LONG).show();
            }
        }
        );

        this.binding.ratingButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedRating = 3;
                Snackbar.make(v, String.format("Selected rating of %d", selectedRating), Snackbar.LENGTH_LONG).show();
            }
        }
        );

        this.binding.ratingButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedRating = 4;
                Snackbar.make(v, String.format("Selected rating of %d", selectedRating), Snackbar.LENGTH_LONG).show();
            }
        }
        );

        this.binding.ratingButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedRating = 5;
                Snackbar.make(v, String.format("Selected rating of %d", selectedRating), Snackbar.LENGTH_LONG).show();
            }
        }
        );

        this.binding.addRatingToLocButton.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when associated button is clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {

                // retrieves location name
                final Editable commentEnteredEditable = AddRatingFragment.this.binding.commentField.getText();
                final String commentString = commentEnteredEditable.toString();


                // confirm we have rating number (comment doesn't matter)
                if (selectedRating == 0) {
                    Snackbar.make(v, "Please select a rating to add", Snackbar.LENGTH_LONG).show();
                } else {
                    // notify listener (controller) and add rating //two versions in case comment or not
                    if (commentEnteredEditable != null || !(commentEnteredEditable.equals(""))) {
                        AddRatingFragment.this.listener.addCommentRatingToLoc(commentString, selectedRating,
                                AddRatingFragment.this);
                    } else {
                        AddRatingFragment.this.listener.addRatingToLoc(selectedRating,
                                AddRatingFragment.this);
                    }
                }

                // inform user that rating was successfully added
                Snackbar.make(v, String.format("Successfully added rating of %d to location", selectedRating), Snackbar.LENGTH_LONG).show();

                // clear the input fields to ready them for the next item
                commentEnteredEditable.clear();
            }
        });
    }
}



