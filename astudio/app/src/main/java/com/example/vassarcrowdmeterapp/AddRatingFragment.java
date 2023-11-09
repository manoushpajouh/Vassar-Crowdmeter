package com.example.vassarcrowdmeterapp;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

public class AddRating extends Fragment implements IAddRatingsView {

    FragmentAddRatingBinding binding; // will call the widgets (xml)
    Listener listener; // like the controller --> will recognize when button is clicked etc

    public AddRatingFragment(@NonNull Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentAddRatingBinding.inflate(inflater);
        return this.binding.getRoot();
    }
}