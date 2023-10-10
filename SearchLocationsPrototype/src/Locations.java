import java.util.ArrayList;
import java.util.List;

public class Locations {
    Location deece = new Location("Deece", 5);
    Location library = new Location("Library", 2);

    List<Location> locations = new ArrayList(){{
    }};

    Locations(){
        locations.add(deece);
        locations.add(library);
    }

}
