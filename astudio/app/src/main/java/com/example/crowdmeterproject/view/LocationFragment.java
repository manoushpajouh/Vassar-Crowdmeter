package com.example.crowdmeterproject.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.crowdmeterproject.databinding.FragmentLocationBinding;
import com.example.crowdmeterproject.databinding.FragmentSearchBinding;
import com.example.crowdmeterproject.model.Location;

import java.text.DecimalFormat;

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

        double ratingAve = location.getRatingAve();
        DecimalFormat df = new DecimalFormat("#.0");
        String ratingAveString = df.format(ratingAve);

        this.binding.locationNameText.setText(location.getName());

        if (ratingAve == 0){
            this.binding.crowdRatingDisplay.setText("Not yet rated");
            this.binding.crowdRatingDisplay.setTextSize(30);
        }
        else {
            this.binding.crowdRatingDisplay.setText(ratingAveString);
        }


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


    }
}
