import java.util.List;

public class SearchName {
    public Location searchName(String searchInput, List<Location> locations) {
        Location retLocation = null;

        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).name.contains(searchInput)) {
                retLocation = locations.get(i);
            }
        }

        return retLocation;
    }
}
