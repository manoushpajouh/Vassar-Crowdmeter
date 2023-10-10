import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<Location> locations = new ArrayList<Location>() {{}};

    Controller(){
        Locations ls = new Locations();
        for (Location loc : ls.locations){
            this.locations.add(loc);
        }
    }
}
