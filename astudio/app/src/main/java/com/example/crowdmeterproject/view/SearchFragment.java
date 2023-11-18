package com.example.crowdmeterproject.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.crowdmeterproject.R;
import com.example.crowdmeterproject.databinding.FragmentSearchBinding;
import com.example.crowdmeterproject.model.Location;
import com.google.android.material.snackbar.Snackbar;

public class SearchFragment extends Fragment implements ISearchView {
    FragmentSearchBinding binding;
    Listener listener;
    Button addRatingButton;

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

        this.binding.searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Editable searchBarEditable = binding.searchBar.getText();
                String searchInput = searchBarEditable.toString();

                // notify the listener
                SearchFragment.this.listener.onSearched(searchInput, SearchFragment.this);

            }
        }
        );
    }

    @Override
    public void displaySearchResult(Location searchResult) {
        this.binding.resultText.setText(searchResult.toString());

        if(addRatingButton == null){
            addRatingButton = new Button(this.binding.getRoot().getContext());
            addRatingButton.setText(R.string.add_rating_button_label);
            this.binding.resultsDisplay.addView(addRatingButton);

            addRatingButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v){
                    // notify the listener
                    SearchFragment.this.listener.onAddRatingPress(SearchFragment.this);
                }
            }
            );

        } else {
            this.binding.resultsDisplay.removeView(addRatingButton);
            this.binding.resultsDisplay.addView(addRatingButton);
        }
    }

    @Override
    public void displaySearchFailure() {
        this.binding.resultsDisplay.removeView(addRatingButton);
        this.binding.resultText.setText("Your search did not match any locations");
    }
}