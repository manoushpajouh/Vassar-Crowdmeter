package com.example.crowdmeterproject.view;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.crowdmeterproject.databinding.FragmentDeleteBinding;
import com.example.crowdmeterproject.databinding.FragmentLocationBinding;
import com.example.crowdmeterproject.databinding.FragmentSearchBinding;
import com.google.android.material.snackbar.Snackbar;

/**
 * Class that manages the delete fragment, where an administrator can delete the current
 * location.
 */
public class DeleteFragment extends Fragment implements IDeleteView{
    FragmentDeleteBinding binding;
    IDeleteView.Listener listener;

    public DeleteFragment(Listener listener){
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentDeleteBinding.inflate(inflater);
        // Inflate the layout for this fragment
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String password = "12345"; // requires a password for security reasons

        this.binding.deleteLocButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Editable passwordEditable = binding.passwordField.getText();
                String passwordEntered = passwordEditable.toString();

                if (passwordEntered.equals(password)) {
                    // notify the listener
                    DeleteFragment.this.listener.onDeleteLocPress(DeleteFragment.this);
                    Snackbar.make(v, "Location successfully deleted", Snackbar.LENGTH_LONG).show();
                }
                else {
                    Snackbar.make(v, "Nice try", Snackbar.LENGTH_LONG).show();
                }
            }
        }
        );
    }
}
