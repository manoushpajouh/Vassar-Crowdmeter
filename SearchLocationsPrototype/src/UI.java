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
    }
}

