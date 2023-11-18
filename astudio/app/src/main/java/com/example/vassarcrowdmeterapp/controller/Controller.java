package com.example.vassarcrowdmeterapp.controller;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;

import android.os.Bundle;

//import com.example.vassarcrowdmeterapp.view.MainView;
//import com.example.crowdmeterproject.view.IAddRatingsView;
//import com.example.crowdmeterproject.view.AddRatingFragment;
//import com.example.vassarcrowdmeterapp.view.IMainView;
import com.example.vassarcrowdmeterapp.R;
import com.example.crowdmeterproject.view.AddRatingFragment;
import com.example.crowdmeterproject.view.IAddRatingsView;

public class Controller extends AppCompatActivity implements IAddRatingsView.Listener {

    //IMainView mainView; //ui
    IAddRatingsView addRatingsView;
    //Rating currentRating; //the rating being added
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addRatingsView = new AddRatingFragment(this.addRatingsView);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void addCommentRatingToLoc(String comment, int number, IAddRatingsView view) {

    }
    @Override
    public void addRatingToLoc(int number, IAddRatingsView view) {

    }

    @Override
    public void completedRatings() {

    }
}