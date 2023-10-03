# Non-Functional Specifications
What is not covered in the use-cases:


## Usability 
1. Color and ratings will correspond. Key notifies user what color responds where
   * Dark Green = 1 (very empty)
   * Light Green = 2 (considerably empty)
   * Yellow = 3 (moderately full)
   * Orange = 4 (pretty full)
   * Red = 5 (very full)
     * see nonfunctional specifications document (nonfunctional-spec.md) for more information 
2. Display message if there are no new reports for a certain area after 1 hour.  


## Reliability

If system fails and most recently reported rating cannot be found: display error message and most recent reporting for the area saved on system.

## Performance

Students want updates made efficiently. The app should modify its overall crowd rating for a location as soon as new information in the form of updates from students is available.  

## Supportability 
Not necessary to be internationally friendly since the app is specific to Vassar College.

## Implementation
Software must run on Android software on portrait mode.
Software written using Java.

## External Interfaces 
None as of yet. 

## Legal
None so far. 

## Other 

Users can report busyness once every 10 minutes. 