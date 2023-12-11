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

public class DeleteFragment extends Fragment implements IDeleteView{
    FragmentDeleteBinding binding;
    IDeleteView.Listener listener;

    public DeleteFragment(Listener listener){
        this.listener = listener;
    }

    /**
     * proper explanation in AddRatingFragment onCreateView
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentDeleteBinding.inflate(inflater);
        // Inflate the layout for this fragment
        return this.binding.getRoot();
    }

    /**
     * see further documentation in AddRatingFragment
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String password = "12345";

        this.binding.deleteLocButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Editable passwordEditable = binding.passwordField.getText();
                String passwordEntered = passwordEditable.toString();

                if (passwordEntered.equals(password)) {
                    // notify the listener
                    DeleteFragment.this.listener.onDeleteLocPress(DeleteFragment.this);
                    Snackbar.make(v, "It's gone", Snackbar.LENGTH_LONG).show();
                }
                else {
                    Snackbar.make(v, "Nice try", Snackbar.LENGTH_LONG).show();
                }
            }
        }
        );
    }
}
