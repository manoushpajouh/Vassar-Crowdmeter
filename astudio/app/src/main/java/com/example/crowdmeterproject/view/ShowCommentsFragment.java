package com.example.crowdmeterproject.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.crowdmeterproject.databinding.ShowCommentsFragmentBinding;
import com.example.crowdmeterproject.model.Location;


public class ShowCommentsFragment extends Fragment implements IShowCommentsView {

    ShowCommentsFragmentBinding binding; // will call the widgets (xml)
    Listener listener; // like the controller --> will recognize when button is clicked etc
    public ShowCommentsFragment(@NonNull Listener listener)
    {
        this.listener = listener;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = ShowCommentsFragmentBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // register add button click listener so you know when you press the button - made interactive

    }

    @Override
    public void displayComments(Location location) {
    // go through each comment of the location and print it
    }
}



