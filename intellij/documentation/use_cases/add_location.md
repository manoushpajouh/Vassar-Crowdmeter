# Add Location

## 1. Primary actor and goals

__Adder__: Wants to add a location to the app. The new location should be fully integrated into all the app's features and searchable by other users.


## 2. Other stakeholders and their goals

* __Viewer__: Needs to be able to find the location and check how crowded it currently is
* __Rater__: Needs to be able to find the location in the app in order to report how crowded it currently is


## 2. Preconditions

* User must have downloaded the app 
* The app must not already exist in the database of Vassar buildings 

## 4. Postconditions

* Location is now available in app to for all users to find 
  * Users are now able to report on the crowd at that location and check the current aggregate crowd rating 
* Adding student is notified that the location was added 

## 4. Workflow

```plantuml
@startuml

skin rose

title Add location (casual)

'define the lanes
|#application|Adder|
|#technology|App|

|Adder|
start
:Choose desired spot for new location;
|App|
:Open campus map to show all locations;

|Adder|
:Input name and area for location in app;

|App|
:Save location details specified by user; 
:Make location available to be viewed by other users;

|Adder|
:Search for location; 

if (Has Rating?) then (yes)
:Execute __Check Busyness__;
else (no)
:Execute __Report Busyness__;
|App|
:Integrate student's report into overall crowd rating;
endif





@enduml
```