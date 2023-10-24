import java.util.List;
/**
 * Class providing the functionality to search the available locations by name.
 */
public class SearchName {
    // returns the first location whose name contains the user's input string (ignoring case)
    public Location search(String searchInput, List<Location> locations) {
        Location retLocation = null;

        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).name.toLowerCase().contains(searchInput.toLowerCase())) {
                retLocation = locations.get(i);
            }
        }

        return retLocation;
    }
}
