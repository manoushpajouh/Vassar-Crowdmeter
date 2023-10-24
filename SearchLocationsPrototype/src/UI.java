import java.util.Scanner;
public class UI {
   public static void main(String args[]){
       Controller c = new Controller();

       String locsString = ""; // lists the names of all available locations for the user

       for (Location loc : c.locations){
           locsString += loc.name + "\n";
       }

       System.out.println("These are all the available locations:\n" + locsString);

       Scanner s = new Scanner(System.in);

       System.out.println("Please input desired location.");
       String searchLoc = s.nextLine();

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

}

