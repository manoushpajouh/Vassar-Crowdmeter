# Add Location

## 1. Primary actor and goals

__Adding student__: Wants to add a location to the app. The new location should be fully integrated into all the app's features and searchable by other users.


## 2. Other stakeholders and their goals

* __Viewing student__: Needs to be able to find the location and check how crowded it currently is
* __Reporting student__: Needs to be able to find the location in the app in order to report how crowded it currently is


## 2. Preconditions

* User must have downloaded the app 

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
|#application|Adding student|
|#technology|App|
|#implementation|Reporting student|
|#orchid|Viewing student|

|Adding student|
start
:Add location to app;

|App|
:Save location details specified by user; 
:Make location available to be viewed by other users;

|Reporting student|
:Search for location; 
:Report crowd at location;

|App|
:Integrate student's report into overall crowd rating;

|Viewing student|
:Search for location; 
:View crowd information for location; 

@enduml
```