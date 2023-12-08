package com.example.crowdmeterproject.view;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.crowdmeterproject.databinding.FragmentShowCommentsBinding;
import com.example.crowdmeterproject.model.Comment;
import com.example.crowdmeterproject.model.Location;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;


public class ShowCommentsFragment extends Fragment implements IShowCommentsView {

    FragmentShowCommentsBinding binding; // will call the widgets (xml)
    Listener listener; // like the controller --> will recognize when button is clicked etc
    Location location; // the location for which the comments are displayed
    public ShowCommentsFragment(@NonNull Listener listener, Location location){
        this.listener = listener;
        this.location = location;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentShowCommentsBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.binding.commentsTitle.setText("Comments for " + location.getName());

        List<Comment> comments = location.getComments();
        Collections.sort(comments);

        if (comments.size() == 0){
            TextView noComments = new TextView(this.binding.getRoot().getContext());
            noComments.setText("No comments yet for this location ...");

            this.binding.commentsDisplay.addView(noComments);
        }
        else {
            for (Comment comment : comments){
                TextView commentText = new TextView(this.binding.getRoot().getContext());
                TextView commentTime = new TextView(this.binding.getRoot().getContext());

                Calendar then = Calendar.getInstance(); // get a calendar to display comment dates/times
                then.setTime(comment.getTime());
                Calendar now = Calendar.getInstance(); // compare comment time to current time
                boolean yearMatches = then.get(Calendar.YEAR) == now.get(Calendar.YEAR);
                boolean monthMatches = then.get(Calendar.MONTH) == now.get(Calendar.MONTH);
                boolean dayMatches = then.get(Calendar.DAY_OF_MONTH) == now.get(Calendar.DAY_OF_MONTH);

                commentText.setText(comment.getText());

                if (yearMatches && monthMatches && dayMatches){
                    commentTime.setText("Today at " + DateFormat.getTimeInstance(DateFormat.SHORT)
                            .format(comment.getTime()));
                }
                else if (yearMatches && monthMatches && (now.get(Calendar.DAY_OF_MONTH) - then.get(Calendar.DAY_OF_MONTH) == 1)){
                    commentTime.setText("Yesterday at " + DateFormat.getTimeInstance(DateFormat.SHORT)
                            .format(comment.getTime()));
                }
                else {
                    commentTime.setText(DateFormat.getDateInstance().format(comment.getTime()));
                }

                commentTime.setTextColor(Color.parseColor("#999999"));
                commentTime.setTextSize(15);

                this.binding.commentsDisplay.addView(commentTime);
                this.binding.commentsDisplay.addView(commentText);
            }
        }

    }
}



