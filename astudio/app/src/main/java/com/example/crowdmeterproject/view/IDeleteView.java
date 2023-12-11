package com.example.crowdmeterproject.view;

public interface IDeleteView {
    public interface Listener{
        /**
         * interface for function following indication of user wanting to delete location
         * @param view the view where the event originated
         */
        void onDeleteLocPress(IDeleteView view);
    }
}
