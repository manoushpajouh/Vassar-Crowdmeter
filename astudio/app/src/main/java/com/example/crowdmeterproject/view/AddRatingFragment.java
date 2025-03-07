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
import com.example.crowdmeterproject.model.Comment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import com.example.crowdmeterproject.model.Rating;
import com.example.crowdmeterproject.R;

/**
 * Class managing the add rating fragment, from which the user can a rating to a location.
 */
public class AddRatingFragment extends Fragment implements IAddRatingsView {

    AddRatingFragmentBinding binding; // will call the widgets (xml)
    Listener listener; // like the controller --> will recognize when button is clicked etc
    int selectedRating;
    public AddRatingFragment(@NonNull Listener listener)
    {
        this.listener = listener;
    }

    /**
     * onCreateView() overrides method of the same name from superclass. It's purpose is to
     * inflate the xml layout associated with the fragment.
     * @param inflater object to use to inflate the xml layout (create actual graphical widgets out of the xml declarations)
     * @param container where the graphical widgets will be placed
     * @param savedInstanceState any saved state information to be restored (null if none exists)
     * @return the root of the layout that has just been inflated
     */

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = AddRatingFragmentBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    /**
     * onViewCreated() overrides method of the same name from superclass. It is called by the
     * android platform after the layout has been inflated, and before the view transitions to the
     * created state.
     *
     * @param view the layout's root view
     * @param savedInstanceState any saved state information to be restored (null if none exists)
     */

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // register add button click listener so you know when you press the button - made interactive
        this.binding.ratingButton1.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when associated button is clicked.
             * @param v The view that was clicked.
             */

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
                Comment comment = new Comment(commentString);


                // confirm we have rating number (comment doesn't matter)
                if (selectedRating == 0) {
                    Snackbar.make(v, "Please select a rating to add", Snackbar.LENGTH_LONG).show();
                } else {
                    // notify listener (controller) and add rating //two versions in case comment or not
                    if (!(commentString.equals(""))) {
                        AddRatingFragment.this.listener.addCommentRatingToLoc(comment, selectedRating,
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



