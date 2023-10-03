# Search locations

## 1. Primary actor and goals
* __Searcher__: Student user who wants to find a location in the app, either to check or report its busyness. 

## 2. Other stakeholders and their goals

None

## 2. Preconditions

* App must have been downloaded by the searcher
* Location being searched for must have been added to the app

## 4. Postconditions

* User has found the location in the app, and is now able to report or check the busyness of that location 

## 4. Workflow

```plantuml
@startuml

skin rose

title Report Busyness (casual)

'define the lanes
|#application|Searcher|
|#technology|App|

|Searcher|
start
:Open App;
:Search for desired location;

|App|
if (Search string is a substring of at least one existing location?) then (yes) 
:Display buttons for all matching locations;
else (no)
:Inform searcher that there are no matching locations;
endif

|Searcher|
:Select button for desired location; 

|App|
:Display page for desired location; 

@enduml
```