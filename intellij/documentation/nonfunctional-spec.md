# Non-Functional Specifications
What is not covered in the use-cases:
## Functionality 
The app will allow you to view a location on Vassar Campus as well as a number and color rating associated with it. 
These features correspond to how busy the location is. The user can also rate a location by inputting their own number and the color will change accordingly. Date and time will be saved in order for ratings to be considered up to date.


## Usability 
1. Color and ratings will correspond. Key notifies user what color responds where
   2. Dark Green = 1 (very empty)
   3. Light Green = 2 (considerably empty )
   4. Yellow = 3 (moderately full)
   5. Orange = 4 (pretty full)
   6. Red = 5 (very full)
   
2. Display message if there are no new reports for a certain area after 1 hour.  


## Reliability 
If system fails and most recently reported rating cannot be found: display error message and most recent reporting for the area saved on system

## Performance

Students want updates made efficiently. 

## Supportability 
Internalization of displayed text (units, numbers, dates)

## Implementation
Software must run on Android software on portrait mode.
Software written using Java.

## External Interfaces 
None as of yet. 