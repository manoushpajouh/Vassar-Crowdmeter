# CMPU-203 F23 - Team 2F


## Name of Application 
Vassar CrowdMeter 

## Descriptions

This application is meant for users (particularly students at Vassar College) to be able to view specific locations on the campus in terms of how busy they are at a particular moment at their convenience. Users are able to submit ratings for any chosen location (or create their own location if it does not previously exist) in order to keep the busyness ratings as updated as possible. These ratings go from a 1-5 scale (in terms of density: 1 being pretty empty, 5 being super full). Furthermore, users can choose to leave comments with their ratings (which in future versions administrators can then filter through in order to prevent spam) 

Right now the application allows the user to input the location desired to check the rating and then prints out the current status of that location for the user to see. The user can choose if they want to rate the location and can input a rating (whole number 1-5). The app will then add that rating to the location and print the rating it just added, as well as the new average rating for that location.

There is a recent implementation of an administrator mode that allows for the administrator to delete locations other users have made. To do so, the screen is password protected. As of now the password is 12345. This is done in order for spam locations or repeated locations to be deleted at a timely manner.

## Visuals
As of now, the app is limited to display a list of all of the already existing locations within the program for the user to click on to add/view a comment or to add a rating after searching a location. There are buttons for viewing the location's rating, searching for the rating, and adding the user's own rating.

When rating a location's busyness, there are 5 buttons per rating that are color coordinated to specify how busy the particular location is at that given moment.


The bottom of the app continuously displays "Browse" and "Add" buttons in order for the user to always be able to look for a specific location or add a location no matter where they are in the app.

## Installation
To run the text prototype: open the UI class folder (UI.java file) and run the main() method. From there, instructions on how to proceed will appear on the terminal, informing the user what to type in for the next step. Follow the instructions by typing in examples (for example: when asked for a location, enter "deece") and the prototype will continue to the next step, allowing the user to proceed to the following instruction (whether that be to view a rating or add a location).

To run the Android Studio prototype: use the Device Manager in the top right corner and run the program using the Pixel 5 version of the simulator. Then input a location to search for a location (the keyboard will pop up). If the location already exists, the rating for it will show up and you can add your own. Otherwise, add your own location.



## Support
For help, contact either of the following administrators: 

Zach Watson: zwatson@vassar.edu

Manoush Pajouh: mpajouh@vassar.edu

## Authors and acknowledgment
The following worked on this application: 
Zach Watson (zwatson@vassar.edu)
Manoush Pajouh (mpajouh@vassar.edu)

with help from: Rui Meireles 
