package com.example.crowdmeterproject.view;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.crowdmeterproject.R;
import com.example.crowdmeterproject.databinding.FragmentSearchBinding;
import com.example.crowdmeterproject.model.Location;
import com.google.android.material.button.MaterialButton;

import java.util.List;

/**
 * Class that manages the search fragment, where the user searches for existing locations.
 */
public class SearchFragment extends Fragment implements ISearchView {
    FragmentSearchBinding binding;
    Listener listener;

    public SearchFragment(@NonNull Listener listener){
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentSearchBinding.inflate(inflater);
        // Inflate the layout for this fragment
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.binding.searchLocsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Editable searchBarEditable = binding.searchBar.getText();
                String searchInput = searchBarEditable.toString();

                // notify the listener
                SearchFragment.this.listener.onSearched(searchInput, SearchFragment.this);
            }
        }
        );

        displaySearchResults(this.listener.getAllLocations());
    }

    /**
     * Displays any results for the user's search. Each result has a background color that
     * corresponds to its current rating average and a button to view the location, both of
     * which are created programmatically and added to the existing table layout.
     * @param searchResults the list of locations match the user's search string
     */
    @Override
    public void displaySearchResults(List<Location> searchResults) {

        // clear out the existing results display to make way for new locations
        while(this.binding.resultsDisplay.getChildCount() > 0){
            View nextChild = (this.binding.resultsDisplay).getChildAt(0);
            this.binding.resultsDisplay.removeView(nextChild);
        }

        for (Location location : searchResults){
            String color; // the color that corresponds to the average crowd rating

            if (location.getRatingAve() == 0){
                color = "#30999999";
            }
            else if (location.getRatingAve() < 1.5){
                color = "#304CAF50";
            }
            else if (location.getRatingAve() < 2.5){
                color = "#308BC34A";
            }
            else if (location.getRatingAve() < 3.5){
                color = "#30FFC73B";
            }
            else if (location.getRatingAve() < 4.5) {
                color = "#30FF9800";
            }
            else {
                color = "#30FF5722";
            }


            // add a row to the table to display a location, and set its background to the right color
            TableRow locationRow = new TableRow(this.binding.getRoot().getContext());
            locationRow.setBackgroundColor(Color.parseColor(color));
            this.binding.resultsDisplay.addView(locationRow);
            // display the location name in the row
            TextView locationNameText = new TextView(this.binding.getRoot().getContext());
            locationNameText.setText("   " + location.getName() + "   ");
            locationNameText.setTextSize(18);
            locationNameText.setTextColor(Color.parseColor("#000000")); // black so that it stands out
            locationRow.addView(locationNameText);
            // add a button to the row to view the location
            MaterialButton viewLocationButton = new MaterialButton(this.binding.getRoot().getContext());
            viewLocationButton.setText(R.string.view_location_button_label);
            locationRow.addView(viewLocationButton);
            // make the button clickable
            viewLocationButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v){
                    // notify the listener
                    SearchFragment.this.listener.onViewLocationPress(SearchFragment.this, location);
                }
            }
            );
        }
    }

    /**
     * Called when the user's search string matches no locations. Informs the user.
     */
    @Override
    public void displaySearchFailure() {
        TextView failureText = new TextView(this.binding.getRoot().getContext());
        failureText.setText("Your search did not match any locations");
        this.binding.resultsDisplay.addView(failureText);
    }
}