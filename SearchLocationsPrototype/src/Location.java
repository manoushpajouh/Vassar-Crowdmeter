import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Class that defines a location object with name and crowd rating fields.
 */
public class Location {
    public String name; // name of location
    int crowdRating; // how busy is it, 1-5?
    List<Rating> allRatings = new ArrayList<>(){{}}; // list of ratings for specific location


    public Location(String name, int crowdRating){
        this.name = name;
        this.crowdRating = crowdRating;
    }

    // to print a location, display its name and its crowd
    public String toString(){
        return "Location name: " + name + "\nCrowd rating: " + crowdRating;
    }

    /**
     * To get the rating for a location: get the average of all the ratings for that location
     * This method will get the overall, average rating for a location
     * by iterating through the list of ratings, getting the sum of the ratings number
     * adding all rating numbers and dividing it by how many there are
     */
    public int getRatingAve(){
        int sizeOfRatings = allRatings.size(); //size of allRatings list
        int counter = 0;     //counter represents the accumulating number from all the ratings added up
        for (int i = 0; i < sizeOfRatings; i++) { //iterate through the linked list of allRatings
            counter = counter + allRatings.get(i).number;
        }
        crowdRating = counter / sizeOfRatings;
        return crowdRating;
    }

    /**
     * Function will return the string for whatever color the average rating should be
     */
    //prints out what color each rating will be depending on the number
    public String assignColor(){
        String color = null;
        //switch case for every color it could be
        switch (crowdRating){
            case 1:
                color = "Dark Green";
                break;
            case 2:
                color = "Light Green";
                break;
            case 3:
                color = "Yellow";
                break;
            case 4:
                color = "Orange";
                break;
            case 5:
                color = "Red";
                break;
            //default is null color
            default:
                color = null;
        }
        return color;
    }
}
