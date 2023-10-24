import java.util.Scanner;
/**
 * The user interface of this application: interacts with the Controller class to display all available locations to
 * the user and then displays the results of the user's search for a particular location.
 */
public class UI {
   public static void main(String args[]){
       Controller c = new Controller(); // accesses the controller class

       String locsString = ""; // lists the names of all available locations for the user

       for (Location loc : c.locations){ // adds each location in the controller to locString
           locsString += loc.name + "\n";
       }

       System.out.println("These are all the available locations:\n" + locsString);

       Scanner s = new Scanner(System.in);

       System.out.println("Please input desired location.");
       String searchLoc = s.nextLine();

       if (c.searchByName(searchLoc) == null){ // if user input does not match any locations, say so
           System.out.println("No locations match your search.");
       }
       else {
           System.out.println(c.searchByName(searchLoc)); // otherwise, use searchByName method in controller to produce the correct location
       }
    }
}

