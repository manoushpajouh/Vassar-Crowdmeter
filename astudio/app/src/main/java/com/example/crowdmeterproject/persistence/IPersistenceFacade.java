package com.example.crowdmeterproject.persistence;

import com.example.crowdmeterproject.model.Location;
import com.example.crowdmeterproject.model.LocationsLibrary;

public interface IPersistenceFacade {
    interface Listener {
        public void onLibRecieved(LocationsLibrary lib);
    }

    /**
     * Saves a location to the database
     * @param location the location to be saved
     */
    void saveLocation(Location location);
    void updateRatingAverage(double average, Location location);
    void deleteLocation(Location location);
    void retrieveLocationsLibrary(Listener listener);
}
