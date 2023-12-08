package com.example.crowdmeterproject.view;

import com.example.crowdmeterproject.model.Comment;
import com.example.crowdmeterproject.model.Rating;

/**
 *  Define the methods necessary to add Rating to a Location
 */
public interface IAddRatingsView {

    /**
     * Interface has to contain the listener to know when actions are done, screens to
     * change etc.
     */
    interface Listener {
        /**
         * Called when a Rating with a comment is added to the Location
         *
         * @param comment the comment attached to the rating
         * @param number rating number going to be added
         * @param view the view where the event originated
         */
        void addCommentRatingToLoc(Comment comment, int number, IAddRatingsView view);

        /**
         * Called when a Rating without a comment is added to the Location
         *
         * @param number rating number going to be added
         * @param view the view where the event originated
         */
        void addRatingToLoc(int number, IAddRatingsView view);

        /**
         * Called when the user is done adding rating.
         */
        void completedRatings();
    }
}
