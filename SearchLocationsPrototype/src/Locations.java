import java.util.ArrayList;
import java.util.List;
/**
 * Class that contains a list of all avaiable locations.
 */
public class Locations {
    Location deece = new Location("Deece", 5); // location named "Deece" with a crowd rating of 5
    Location library = new Location("Library", 2);

    List<Location> locations = new ArrayList(){{}}; // this is a list of all locations

    // at this point, deece and library are automatically added in the constructor
    Locations(){
        locations.add(deece);
        locations.add(library);
    }

}
