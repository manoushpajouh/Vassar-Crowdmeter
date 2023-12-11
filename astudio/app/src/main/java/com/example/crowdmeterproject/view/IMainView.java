package com.example.crowdmeterproject.view;

import android.view.View;

import androidx.fragment.app.Fragment;

public interface IMainView{

    public interface Listener {
        void onAddPress();
        void onSearchPress();
    }
    /**
     * Retrieve the graphical widget (android view) at the root of the screen hierarchy/
     * @return the screen's root android view (widget)
     */

    public View getRootView();
    /**
     * Replaces the contents of the screen's fragment container with the one passed in as an argument.
     *
     * @param fragment The fragment to be displayed.
     * @param reversible true if this transaction should be reversible, false otherwise
     * @param name the name this transaction can be referred by.
     */

    public void displayFragment(Fragment fragment, boolean reversible, String name);
}
