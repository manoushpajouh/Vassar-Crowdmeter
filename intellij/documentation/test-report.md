# Test Report 

The prototype should be able to a) display information for a location if it matches the user's input, or b) display a message indicating 
that there are no matching locations. A location matches the user's search string if the location name contains this string, ignoring case. 
To test this first case, we put in search strings that either were identical to a location name, were a substring of a location 
name, or were a substring of a location name that did not have the same cases for some of the letters. To test the second case, we inputted 
search strings that were not substrings of any location name. 

## Terminal input/output for each test 
### Test 1 
These are all the available locations: 

Deece 

Library

Please input desired location. 

Deece


Location name: Deece


Crowd rating: 5

Process finished with exit code 0

### Test 2

These are all the available locations:

Deece

Library

Please input desired location.

Lib


Location name: Library


Crowd rating: 2

Process finished with exit code 0

### Test 3

These are all the available locations:

Deece

Library

Please input desired location.

LIBrary


Location name: Library


Crowd rating: 2

Process finished with exit code 0

### Test 4 

These are all the available locations:

Deece

Library

Please input desired location.

zxckvjhjz


No locations match your search.

Process finished with exit code 0

