import java.util.ArrayList;
import java.util.List;
/**
 * Class that contains a list of all available locations.
 */
public class Locations {
    List<Location> locations = new ArrayList(){{}}; // this is a list of all locations

    Locations(){}

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
