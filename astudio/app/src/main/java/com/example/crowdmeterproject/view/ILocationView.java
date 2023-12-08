package com.example.crowdmeterproject.view;

public interface ILocationView {

    public interface Listener {
        void onAddRatingPress(ILocationView view);
        void onViewCommentsPress(ILocationView view);
    }
}
