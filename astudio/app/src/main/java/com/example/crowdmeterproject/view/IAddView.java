package com.example.crowdmeterproject.view;

public interface IAddView {
    public interface Listener {
        void onAdded(int crowdRating, String locationName, IAddView view);
    }
}
