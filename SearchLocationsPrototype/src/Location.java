public class Location {
    public String name; // name of location
    int crowdRating; // how busy is it, 1-5?

    public Location(String name, int crowdRating){
        this.name = name;
        this.crowdRating = crowdRating;
    }

    public String toString(){
        return "Location name: " + name + "\nCrowd rating: " + crowdRating;
    }



}
