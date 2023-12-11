package com.example.crowdmeterproject.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

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
     * Function checks whether or not the location already exists within the locations list
     */
    public boolean locationExists(com.example.crowdmeterproject.model.Location location) {
        boolean locExists = false;
        //for each index in the array list
        for (int i = 0; i < locations.size(); i++) {
            locExists = (locations.get(i).equals(location)); // return true if location already in the list
        }
        return locExists;
    }

    /**
     * The following function will add a newly created location to the list locations
     * @param name is  the name of the location
     */
    public Location addLocation(String name){
        Location l = new Location(name);
        locations.add(l);
        return l;
    }

    /**
     * removes location l from location library
     * @param l the location to be removed
     */
    public void deleteLocation(Location l){
        locations.remove(l);
    }

    /**
     * allows user to search through the list of locations in the library and return whatever contains their search
     * @param searchInput what the user is looking for
     * @return the locations in location library that contains the search input
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

    /**
     * returns the locations in the locations library
     * @return locations in locations library
     */
    public List<Location> getLocations(){
        return this.locations;
    }
}
