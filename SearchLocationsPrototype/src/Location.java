/**
 * Class that defines a location object with name and crowd rating fields.
 */
public class Location {
    public String name; // name of location
    int crowdRating; // how busy is it, 1-5?

    public Location(String name, int crowdRating){
        this.name = name;
        this.crowdRating = crowdRating;
    }

    // to print a location, display its name and its crowd
    public String toString(){
        return "Location name: " + name + "\nCrowd rating: " + crowdRating;
    }



}
