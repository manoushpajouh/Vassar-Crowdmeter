public class Rating {
    int number;
    String color = null;
    String comment = null;

    //constructor - what you need to make a rating
    public Rating(int number){
        //make sure the parameter is equal to the field
       this.number = number;

    }
    //two constructors because you can make a rating without making a comment
    public Rating(int number, String comment){
        this.number = number;
        this.comment = comment;


    }
    //prints out what color each rating will be depending on the number
    public String assignColor(){
        //switch case for every color it could be
        switch (number){
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
