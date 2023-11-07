import java.util.ArrayList;
import java.util.List;
/**
 * Has access to the list of all locations, and contains a method that recruits the searchName class to search this
 * list by name.
 */
public class Controller {
    List<Location> locations = new ArrayList<Location>() {{}}; // this list consists of all available locations
    private Locations ls = new Locations(); // the locations library used in a particular run of the program

    // initializes the locations field
    Controller(){
        for (Location loc : ls.locations){
            this.locations.add(loc);
        }
    }

    // calls the search function within searchName class
    public Location searchByName(String searchInput){
        return ls.searchByName(searchInput);
    }

    // directs the locations class to add a new location
    public void addLocation(String newLoc){
        ls.addLocation(newLoc);
    }

    public void update(){
        locations = ls.locations;
    }

    public List<Location> getLocations(){
        return locations;
    }
}
