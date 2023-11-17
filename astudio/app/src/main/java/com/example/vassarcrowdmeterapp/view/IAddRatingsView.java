package com.example.vassarcrowdmeterapp.view;

import com.example.vassarcrowdmeterapp.model.Rating;

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
        void addCommentRatingToLoc(String comment, int number, IAddRatingsView view);

        /**
         * Called when a Rating without a comment is added to the Location
         *
         * @param number rating number going to be added
         * @param view the view where the event originated
         */
        void addRatingToLoc(int number, IAddRatingsView view);

        /**
         *
         *
         * Called when the user is done adding rating.
         */
        void completedRatings();
    }

    /**
     * Update display to reflect contents of the rating passed as an argument.
     * @param rating is the rating going to be displayed
     *        the rating most recently added
     */
    void updateRatingDisplay(Rating rating);
}
