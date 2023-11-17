package com.example.crowdmeterproject.model;

import java.util.ArrayList;
import java.util.List;

public class LocationsLibrary {
    List<Location> locations = new ArrayList(){{}}; // a list of all locations

    public LocationsLibrary(){
    }

    public void addLocation(String name, int initialRating){
        Location l = new Location(name, initialRating);
        locations.add(l);
    }

    public Location searchByName(String searchInput) {
        Location retLocation = null;

        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).name.toLowerCase().contains(searchInput.toLowerCase())) {
                retLocation = locations.get(i);
            }
        }

        return retLocation;
    }

    public List<Location> getLocations(){
        return this.locations;
    }
}
