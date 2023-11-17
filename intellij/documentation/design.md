# OVERALL DOMAIN MODEL 
```plantuml
@startuml

skin rose 

hide circle 
hide circle 

' classes 

class User{
}

class Rating{
number
comment
}

class LocationsOptions{
locations list
}

class Location{
name
crowdRating
allRatings
}

' associations 
Rating "1..*"  - "1" Location : \t describes \t
User "1..*" -- "1..*" Rating : creates
LocationsOptions "1" -down- "*" Location : contains
User "1..*" -right- "1" LocationsOptions: \t searches-through\t

@enduml
```


# OVERALL DESIGN CLASS DIAGRAM  

```plantuml
@startuml

class User{
}

class Rating{
number: int
comment: String
--
Rating(int number)
Rating(int number, String comment)
--
toString(): String 

}

class LocationsOptions{
locations: Location ArrayList 
--
locationExists(): boolean
toString(): String
addLocation(): void
searchByName(): Location
}

class Location {
name: String
crowdRating: double
allRatings: Array List of Ratings 
--
toString(): String
addRating(): void
addCommentRating(): void
getRatingAve(): double
assignColor(): String 
}


User .down.> Rating
User .> LocationsOptions
Rating .right.> Location
LocationsOptions .down.> Location

' associations 
Rating "1..*"  - "1" Location : \t describes \t
User "1..*" -- "1..*" Rating : creates
LocationsOptions "1" -down- "*" Location : contains
User "1..*" -right- "1" LocationsOptions: \t searches-through\t


@enduml
```

# SEQUENCE DIAGRAMS
## Browse locations

```plantuml
@startuml
actor User as user
participant " :User Interface" as ui
participant " :Controller" as controller
participant " searchName" as sn
participant " :Locations"  as locations
locations -> controller: list of all locations
controller -> ui: list of all locations
ui -> user: display location.name for each location
user -> ui: input desired location name
ui -> controller: desired location name
controller -> sn: searchByName(desired location name)
sn -> locations: search(desired location name)
locations -> sn: desired location
sn -> controller: desired location
controller -> ui: desired location
ui -> user: display desired location info 
@enduml
```

# Report Busyness Sequence Diagram : Goal Diagram 

```plantuml
@startuml
actor Rater as rater 
participant " : User Interface" as ui
participant " : Controller" as controller
participant " : Location" as location 
participant " : LocationsOptions" as locOps 
participant " : Rating" as ratings 
participant " : ratingTimer" as timer 

rater -> ui  : select "Rate A Location"
ui -> controller : run timeOver()
controller -> timer : timeOver()
timer -> controller : return timeOver()
controller -> ratings  : canRate()
ratings -> controller : return canRate()
alt canRate()

controller -> locOps :  Get locationsList
locOps -> ui : Return locationsList
ui ->  rater : Display locationsList
rater -> ui : select a location
ui -> controller : run locationExists
controller -> locOps: locationExists

alt !locationExists()
locOps -> location : Execute __Add Location__ 
location -> controller : return location 
else locationExists()
locOps  -> controller : getLocation()
end

controller -> ui : Open Textbox for User 
ui -> rater : Display Textbox to Rate
rater -> ui : Enter Rating Requirements
ui -> controller : Input into makeRating
controller -> ratings : makeRating(number: int, color: String, comment: String)

ratings -> timer : updateTime();
timer -> controller : return getTime()
controller -> ui : display getTime()
ui -> rater : Display "Time Until Next Rating"

else !canRate()
ui -> rater : Display "Timer Not Yet Over"
end

@enduml
```

# Current Version of Report Busyness

```plantuml
@startuml
actor Rater as rater 

participant " : User Interface" as ui
participant " : Controller" as controller
participant " : Location" as location 
participant " : LocationsOptions" as locOps 
participant " : Rating" as ratings 

controller -> locOps : Execute __Check Busyness__
    alt !locationExists()
        locOps -> location : Execute __Add Location__ 
    else locationExists()
        locOps  -> controller : getLocation()
    end
   
controller -> ui : Open Text box for User
ui -> rater : Display Text box to Rate
rater -> ui : Enter Rating Requirements
ui -> controller : location.addRating()
controller -> ratings : addCommentRating(number: int, comment: String)
controller -> ratings : addRating(number: int)

end
@enduml
```

# Check Busyness Sequence Diagram

```plantuml
@startuml
actor Viewer as viewer 
participant " : User Interface" as ui
participant " : Controller" as controller
participant " : Location" as location 
participant " : LocationsOptions" as locOps 
participant " : Rating" as ratings 

ui -> controller : locationsOptions.toString()
controller -> locOps :  toString();
ui -> viewer : display locationsOptions.toString()

viewer -> ui : Enter location

    alt locationExists() 
    controller -> location: getRatingAve()
    location -> controller : return getRatingAve()
    controller -> ui : display getRatingAve()
    ui -> viewer : display "Want To Add Rating?" and "Yes" "No" options
        alt yes
        viewer -> ui : Choose "Yes"
        ui -> controller : Execute __Report Busyness__
        
        else no 
        viewer -> ui : Choose "No" 
        ui -> controller : Close  
        end
    
    else !locationExists()
    ui -> controller: execute __Add Location__

end

@enduml
```

# Add Location Sequence Diagram

```plantuml
@startuml
actor Viewer as viewer 
participant " : User Interface" as ui
participant " : Controller" as controller
participant " : Location" as location 
participant " : LocationsOptions" as locOps 
participant " : Rating" as ratings 

viewer -> ui : Enter Name for Location 
ui -> controller : locOps.toString()
controller -> locOps : addLocation();


@enduml
```
