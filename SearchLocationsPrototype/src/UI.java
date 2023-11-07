import java.util.Scanner;
import static java.lang.Integer.parseInt;

/**
 * The user interface of this application: interacts with the Controller class to display all available locations to
 * the user and then displays the results of the user's search for a particular location.
 */
public class UI {
    public static void main(String args[]) {
        Controller c = new Controller(); // accesses the controller class

        while (true) {
            System.out.println("What would you like to do? Type 'add' if you would like to add a new location, or 'search' if you would like to browse existing locations.");
            Scanner s = new Scanner(System.in);
            String useCase = s.nextLine();

            if (useCase.equalsIgnoreCase("search")) {
                String locsString = ""; // lists the names of all available locations for the user
                for (Location loc : c.getLocations()) { // adds each location in the controller to locString
                    locsString += loc.name + "\n";
                }

                if (locsString.equals("")) {
                    System.out.println("There are no locations at this time. Type 'add' to add a new location.");
                    continue;
                }

                System.out.println("These are all the available locations:\n" + locsString);

                System.out.println("Please input desired location.");
                String searchLoc = s.nextLine();
                Location foundLoc = c.searchByName(searchLoc);

                if (foundLoc == null) { // if user input does not match any locations, say so
                    System.out.println("No locations match your search.");
                } else {
                    System.out.println(foundLoc); // otherwise, use searchByName method in controller to produce the correct location

                    //adding a new rating through user input terminal
                    System.out.println("Want to add rating? Type 'Yes' or 'No'");
                    String rateOption = s.nextLine();

                    if (rateOption.equalsIgnoreCase("Yes")) { //do not use == bc of memory issues
                        System.out.println("Input your desired rating from 1 to 5 (whole numbers only)");
                        int rateNum = parseInt(s.nextLine());            //convert rateNum from string to integer

                        System.out.println("Do you want to add a comment? Type 'Yes' or 'No'");
                        String commentOption = s.nextLine();
                        if (commentOption.equalsIgnoreCase("Yes")) {
                            System.out.println("Please enter your comment:");
                            String cm = s.nextLine();
                            Rating rating = new Rating(rateNum, cm);

                            //add rating to the list so that the counter will still work
                            foundLoc.allRatings.add(rating);
                            System.out.println("Adding Your Rating of " + rating.number + " to " + foundLoc.name);
                            System.out.println("New Overall Rating of " + foundLoc.crowdRating + " at " + foundLoc.name);
                        }
                        //dont want comment
                        else {
                            Rating rating = new Rating(rateNum);
                            //add rating to the list so that the counter will still work
                            foundLoc.allRatings.add(rating);
                            System.out.println("Adding Your Rating of " + rating.number + " to " + foundLoc.name);
                            System.out.println("New Overall Rating of " + foundLoc.getRatingAve() + " at " + foundLoc.name);
                        }
                    }
                    else {
                        continue;
                    }
                }
                } else if (useCase.equalsIgnoreCase("add")) {
                    System.out.println("Please enter the name of the location you would like to add.");
                    String newLoc = s.nextLine();

                    c.addLocation(newLoc);
                    c.update();

                    System.out.println("Success! Thank you for adding " + newLoc + ".");

                } else {
                    System.out.println("Please type either 'add' or 'search'.");
                }
            }
        }
    }




//need it to be in a loop so that if yes or no is put in wrong you can try again
       /*
           System.out.println("Want to add rating? Input 'Yes' or 'No'");
           String rateOption = s.nextLine();
            if (rateOption == "Yes"){
                System.out.println("Input your desired rating number:");
                String rateNum = s.nextLine();
                System.out.println("Do you want to add a comment?");
                String commentOption = s.nextLine();
                    if (commentOption == "Yes"){
                        System.out.println("Please enter your comment:");
                        String cm = s.nextLine();
                        Rating rating = new Rating(rateNum, cm);
                    }
                    //dont want comment
                    else (){
                    Rating rating = new Rating(rateNum);
                    System.out.println("Adding Your Rating of" + rating.number +"to" + c.searchByName(searchLoc))
                    }
            }
            //if they do not want to add a rating --> break out of loop
            else if (rateOption == "No"){
                break;
            }
            //if input doesnt match yes or no --> restart loop
            else {

            }
   }

        */


