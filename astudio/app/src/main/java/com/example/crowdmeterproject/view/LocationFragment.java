package com.example.crowdmeterproject.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.crowdmeterproject.databinding.FragmentLocationBinding;
import com.example.crowdmeterproject.databinding.FragmentSearchBinding;
import com.example.crowdmeterproject.model.Location;

import java.text.DecimalFormat;

/**
 * Class that manages the location fragment. This fragment displays the crowd rating
 * (can be filtered by time) for a location, and has buttons to add a rating to a location
 * and view the comments for that location.
 */
public class LocationFragment extends Fragment implements ILocationView{
    FragmentLocationBinding binding;
    Listener listener;
    Location location;

    public LocationFragment(@NonNull Listener listener, Location location){
        this.listener = listener;
        this.location = location;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentLocationBinding.inflate(inflater);
        // Inflate the layout for this fragment
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        double ratingAve; // the average rating to be displayed

        binding.timeRangeSpinner.setSelection(0); // display crowd rating for all time by default
        // sets listener for time range spinner (used to filter rating average)
        binding.timeRangeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        binding.sliderLabel.setText("Displaying average for all time");
                        break;
                    case 1:
                        binding.sliderLabel.setText("Displaying average for 1 hr");
                        break;
                    case 2:
                        binding.sliderLabel.setText("Displaying average for 2 hrs");
                        break;
                    case 3:
                        binding.sliderLabel.setText("Displaying average for 4 hrs");
                        break;
                    case 4:
                        binding.sliderLabel.setText("Displaying average for 6 hrs");
                        break;
                    case 5:
                        binding.sliderLabel.setText("Displaying average for 8 hrs");
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        // get the right value of ratingAve depending on what the user selected
        switch((String) binding.sliderLabel.getText()){
            case ("Displaying average for 1 hr"):
                ratingAve = location.getRatingAveTime(1);
                break;
            case ("Displaying average for 2 hrs"):
                ratingAve = location.getRatingAveTime(2);
                break;
            case ("Displaying average for 4 hrs"):
                ratingAve = location.getRatingAveTime(4);
                break;
            case ("Displaying average for 6 hrs"):
                ratingAve = location.getRatingAveTime(6);
                break;
            case ("Displaying average for 8 hrs"):
                ratingAve = location.getRatingAveTime(8);
                break;
            default:
                ratingAve = location.getRatingAve();
        }
        // round the average rating to one decimal point
        DecimalFormat df = new DecimalFormat("#.0");
        String ratingAveString = df.format(ratingAve);

        this.binding.locationNameText.setText(location.getName());
        // if the rating average is 0, this means the location was never rated
        if (ratingAve == 0){
            this.binding.crowdRatingDisplay.setText("Not yet rated");
            this.binding.crowdRatingDisplay.setTextSize(30);
        }
        else {
            this.binding.crowdRatingDisplay.setText(ratingAveString);
        }

        // set color of rating average to match rating rounded to nearest whole number
        if (ratingAve == 0){
            this.binding.crowdRatingDisplay.setTextColor(Color.parseColor("#999999"));
        }
        else if (ratingAve < 1.5){
            this.binding.crowdRatingDisplay.setTextColor(Color.parseColor("#4CAF50"));
        }
        else if (ratingAve < 2.5){
            this.binding.crowdRatingDisplay.setTextColor(Color.parseColor("#8BC34A"));
        }
        else if (ratingAve < 3.5){
            this.binding.crowdRatingDisplay.setTextColor(Color.parseColor("#FFC73B"));
        }
        else if (ratingAve < 4.5) {
            this.binding.crowdRatingDisplay.setTextColor(Color.parseColor("#FF9800"));
        }
        else {
            this.binding.crowdRatingDisplay.setTextColor(Color.parseColor("#FF5722"));
        }

        this.binding.addRatingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                // notify the listener
                LocationFragment.this.listener.onAddRatingPress(LocationFragment.this);
            }
        }
        );
        this.binding.viewCommentsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                // notify the listener
                LocationFragment.this.listener.onViewCommentsPress(LocationFragment.this);
            }
        }
        );
        this.binding.deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                // notify the listener
                LocationFragment.this.listener.onDeletePress(LocationFragment.this);
            }
        }
        );
    }
}
