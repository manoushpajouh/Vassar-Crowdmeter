import java.util.ArrayList;
import java.util.List;
/**
 * Class that contains a list of all avaiable locations.
 */
public class LocationsOptions {
    List<Location> locations = new ArrayList(){{}}; // this is a list of all locations
    LocationsOptions(){
    }

    /**
     * Function essentially prints locations (list) in string format
      */
    public String toString(){
        //call toString() for each location
        String locsString = ""; // lists the names of all available locations for the user
        for (Location loc : locations){ // adds each location in the controller to locString
            locsString += loc.toString() + "\n";
        }
        return locsString;
}
    /**
     * Function checks whether or not the location already exists within the locations list
     */
    public boolean locationExists(Location location) {
        boolean locExists = false;
        //for each index in the array list
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i) == location) {
                locExists = true; // return true if location already in the list
            } else {
                locExists = false;
            }
        }
        return locExists;
    }
}

    /**
     * The following function will add a newly created location to the list locations
     * @param name
     */
    public void addLocation(String name){
        Location l = new Location(name, 0);
        locations.add(l);
    }

    /**
     * The following function allows user to search for a location. Returns location if it is already
     * in the list locations. Otherwise
     * @param searchInput : location being searched for
     * @return Location that is found
     */
    public Location searchByName(String searchInput) {
        Location retLocation = null;

        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).name.toLowerCase().contains(searchInput.toLowerCase())) {
                retLocation = locations.get(i);
            }
        }

        return retLocation;
    }
}