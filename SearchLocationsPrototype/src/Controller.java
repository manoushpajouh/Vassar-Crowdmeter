import java.util.ArrayList;
import java.util.List;
/**
 * Has access to the list of all locations, and contains a method that recruits the searchName class to search this
 * list by name.
 */
public class Controller {
    List<Location> locations = new ArrayList<Location>() {{}}; // this list consists of all available locations

    // initializes the locations field
    Controller(){
        Locations ls = new Locations();
        for (Location loc : ls.locations){
            this.locations.add(loc);
        }
    }

    // calls the search function within searchName class
    public Location searchByName(String searchInput){
        SearchName sn = new SearchName();
        return sn.search(searchInput, locations);
    }
}
