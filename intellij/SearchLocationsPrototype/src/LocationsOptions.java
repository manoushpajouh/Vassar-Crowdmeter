import java.util.ArrayList;
import java.util.List;
/**
 * Class that contains a list of all avaiable locations.
 */
public class LocationsOptions {
    List<Location> locations = new ArrayList(){{}}; // this is a list of all locations
    Location deece = new Location("Deece", 5); // location named "Deece" with a crowd rating of 5
    Location library = new Location("Library", 2);
    // at this point, deece and library are automatically added in the constructor
    LocationsOptions(){
        locations.add(deece);
        locations.add(library);
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
