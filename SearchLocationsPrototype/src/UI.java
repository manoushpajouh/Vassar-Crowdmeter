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

<<<<<<< HEAD
       SearchName sn = new SearchName();
       System.out.println(sn.searchName(searchLoc, c.locations));















       //need it to be in a loop so that if yes or no is put in wrong you can try again
       /*
           System.out.println("Want to add rating? Input 'Yes' or 'No'");
           String rateOption = s.nextLine();
            if (rateOption == "Yes"){
                System.out.println("Do you want to add a comment?");
                String commentOption = s.nextLine();
                    if (commentOption == "Yes"){
                        Rating rating =
                    }



                Rating rating = new Rating();
                System.out.println("Add Your Rating of" + rating.number + "to" sn.)
            }
            else if (rateOption == "No"){

            }
            else {

            }
   }

        */

=======
       if (c.searchByName(searchLoc) == null){ // if user input does not match any locations, say so
           System.out.println("No locations match your search.");
       }
       else {
           System.out.println(c.searchByName(searchLoc)); // otherwise, use searchByName method in controller to produce the correct location
       }
    }
>>>>>>> 34407989379ed072fae4573f3892c1b6b8ac4b54
}

