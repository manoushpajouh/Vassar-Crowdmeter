import java.util.Scanner;

import static java.lang.Integer.parseInt;

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

       SearchName sn = new SearchName();
       Location foundLoc =  sn.search(searchLoc, c.locations); //specify the location found if it is already added
       System.out.println(foundLoc);
       if (c.searchByName(searchLoc) == null){ // if user input does not match any locations, say so
           System.out.println("No locations match your search.");
       }
       else {
           System.out.println(c.searchByName(searchLoc)); // otherwise, use searchByName method in controller to produce the correct location
       }

       //adding a new rating through user input terminal
       System.out.println("Want to add rating? Input 'Yes' or 'No'");
       String rateOption = s.nextLine();
       if (rateOption.equals("Yes")){ //do not use == bc of memory issues
           System.out.println("Input your desired rating number:");
           int rateNum = parseInt(s.nextLine());            //convert rateNum from string to integer
           System.out.println("Do you want to add a comment?");
           String commentOption = s.nextLine();
           if (commentOption.equals("Yes")){
               System.out.println("Please enter your comment:");
               String cm = s.nextLine();
               Rating rating = new Rating(rateNum, cm);
               //add rating to the list so that the counter will still work
               foundLoc.allRatings.add(rating);
               System.out.println("Adding Your Rating of " + rating.number +" to " + searchLoc);
               System.out.println("New Overall Rating of " + foundLoc.crowdRating + "at " + searchLoc);
           }
           //dont want comment
           else {
               Rating rating = new Rating(rateNum);
               //add rating to the list so that the counter will still work
               foundLoc.allRatings.add(rating);
               System.out.println("Adding Your Rating of " + rating.number +" to " + searchLoc);
               System.out.println("New Overall Rating of " + foundLoc.getRatingAve() + " to " + searchLoc);
           }
       }




   }
}