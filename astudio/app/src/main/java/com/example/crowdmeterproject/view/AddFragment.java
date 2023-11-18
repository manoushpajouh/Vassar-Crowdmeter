package com.example.crowdmeterproject.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.crowdmeterproject.R;
import com.example.crowdmeterproject.databinding.FragmentAddBinding;
import com.example.crowdmeterproject.databinding.FragmentSearchBinding;
import com.google.android.material.snackbar.Snackbar;

public class AddFragment extends Fragment implements IAddView {
    Listener listener;
    FragmentAddBinding binding;

    public AddFragment(@NonNull Listener listener){
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentAddBinding.inflate(inflater);
        // Inflate the layout for this fragment
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.binding.addLocButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Editable locationNameEditable = binding.locationName.getText();
                String locationName = locationNameEditable.toString();

                Editable crowdRatingEditable = binding.crowdRating.getText();

                if (crowdRatingEditable.length() == 0){
                    // notify the user
                    Snackbar.make(v, String.format("Successfully added %s with no crowd rating", locationName), Snackbar.LENGTH_LONG).show();
                    // notify the listener
                    AddFragment.this.listener.onAdded(0, locationName, AddFragment.this);
                } else {
                    String crowdRatingString = crowdRatingEditable.toString();
                    int crowdRating = Integer.parseInt(crowdRatingString);

                    // notify the listener
                    AddFragment.this.listener.onAdded(crowdRating, locationName, AddFragment.this);
                    // notify the user
                    Snackbar.make(v, String.format("Successfully added %s with crowd rating of %d", locationName, crowdRating), Snackbar.LENGTH_LONG).show();
                }
            }
        }
        );
    }
}