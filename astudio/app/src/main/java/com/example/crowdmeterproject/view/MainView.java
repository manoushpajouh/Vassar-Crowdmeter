package com.example.crowdmeterproject.view;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.crowdmeterproject.databinding.MainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainView implements IMainView {
    MainBinding binding;
    FragmentManager fragmentManager;
    Listener listener;

    public MainView(FragmentActivity activity, Listener listener) {
        this.listener = listener;
        this.fragmentManager = activity.getSupportFragmentManager();
        this.binding = MainBinding.inflate(activity.getLayoutInflater());

        this.binding.searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                MainView.this.listener.onSearchPress();
            }
        });

        this.binding.addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
            MainView.this.listener.onAddPress();
            }
        });
        }

        public View getRootView() {
            return binding.getRoot();
        }

    @Override
    public void displayFragment(Fragment fragment, boolean reversible, String name) {
        FragmentTransaction ft = fragmentManager.beginTransaction();

        ft.replace(this.binding.useCaseFragment.getId(), fragment);

        if(reversible){
            ft.addToBackStack(name);
        }

        ft.commit();
    }
}
