package com.example.crowdmeterproject.model;

import androidx.annotation.NonNull;

import com.example.crowdmeterproject.persistence.FirestoreFacade;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that stores list of all locations in the app.
 */
public class LocationsLibrary {
    List<Location> locations = new ArrayList(){{}}; // a list of all locations

    public LocationsLibrary(){
    }

    /**
     * Function essentially prints locations (list) in string format
     */
    @NonNull
    public String toString(){
        //call toString() for each location
        StringBuilder locsString = new StringBuilder(); // lists the names of all available locations for the user
        for (com.example.crowdmeterproject.model.Location loc : locations){ // adds each location in the controller to locString
            locsString.append(loc.toString()).append("\n");
        }
        return locsString.toString();
    }
    /**
     * The following function will add a newly created location to the list of locations
     * @param name is  the name of the location
     */
    public Location addLocation(String name) {
        FirestoreFacade f = new FirestoreFacade();
        Location l = new Location(name);
        // add to database
        locations.add(l);
        f.saveLocation(l);
        return l;
    }

    /**
     * Deletes a location from the library.
     * @param l
     */
    public void deleteLocation(Location l){
        locations.remove(l);
        // remove from database
        FirestoreFacade f = new FirestoreFacade();
        f.deleteLocation(l);
    }

    /**
     * Returns all locations whose name matches searchInput.
     * @param searchInput search string
     * @return lisr of all matching locations
     */
    public List<Location> searchByName(String searchInput) {
        List<Location> retLocations = new ArrayList<>();

        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).name.toLowerCase().contains(searchInput.toLowerCase())) {
                retLocations.add(locations.get(i));
            }
        }
        return retLocations;
    }
    public List<Location> getLocations(){
        return this.locations;
    }
    public void setLocations(List<Location> locations){
        this.locations = locations;
    }
}
