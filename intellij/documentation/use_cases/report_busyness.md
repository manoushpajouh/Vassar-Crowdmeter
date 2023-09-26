# Report Busyness

## 1. Primary actor and goals
__Updater__: Wants to update if the area is busy. Wants to change amounts easily.

__System__: save and display the ratings

## 2. Other stakeholders and their goals

* __Viewer__: Wants fast service with minimal effort. Wants accurate, fast data updated Wants easily visible display of locations and crowd amounts. 


## 2. Preconditions

What must be true prior to the start of the use case.

* App has to be downloaded
* Location is identified

## 4. Postconditions

What must be true upon successful completion of the use case.

* Crowd busyness update is saved.
* Crowd intensity is recorded and added to the heatmap.
* Location color on map changes accordingly.
* Updates are recorded.


## 4. Workflow

```plantuml
@startuml

skin rose

title Update Location's Crowd Rating (brief)

'define the lanes
|#application|Updater|
|#technology|Viewer|
|#implementation|System|

|Updater|
start
:Arrive at location;
:Find location on app;
:Enter new rating;

|System|
:Save new rating;
:Display new rating;


|Viewer|
:View new rating;

stop
@enduml
```



