package com.example.crowdmeterproject.view;

import android.view.View;

import androidx.fragment.app.Fragment;

public interface IMainView{

    public interface Listener {
        void onAddPress();
        void onSearchPress();
    }

    public View getRootView();
    public void displayFragment(Fragment fragment, boolean reversible, String name);
}
