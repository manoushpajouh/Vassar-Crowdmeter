
# Manage Location (Edit or Delete)
## 1. Primary actor and goals

* __Admin__: able to edit or delete a particular location in order to prevent duplicate locations, fake locations, etc.
    * Admins are only developers in this version of the ap 
## 2. Other stakeholders and their goals

* None

## 3. Preconditions

* User must be identified and authorized as an administrator
* Location must be available to select in app

## 4. Postconditions

* Other users (viewers and raters) can see changes made by administrator
* Other users cannot override the changes madeby administrator 

## 5. Workflow


```plantuml
@startuml

skin rose

title Manage Location (casual)

'define the lanes
|#application|Admin|
|#technology|App|

|App|
:Display button for admin changes;
|Admin|
:Select button;
|App|
:Display list of all locations;

|Admin|
:Select location to manage;

if (How to Manage?) then (Edit Name)
        :Type in New Name;
        
     |App|
        :Save New Information;
        :Display New Information;
        stop
        
        
|Admin|
else (Delete Location)
    :Remove Location Button;

|App|
:Stop Displaying Location;
:Remove Location's Information
            from Database;

stop
@enduml
```

