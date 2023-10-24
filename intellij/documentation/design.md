# OVERALL DOMAIN MODEL 
```plantuml
@startuml

skin rose 

hide circle 
hide circle 

' classes 

class User{
username
}

class userRating{
number
color
comment
}

class LocationsOptions{
locations
}

class Location{
name
rating
commentSection
}

class ratingTimer{
minutes
seconds
}

class worldClock{
minutes
seconds
}

' associations 
userRating "1"  - "1" Location : \t describes \t
userRating "*" -- "1" ratingTimer : initiates/depends-on \t
User "1..*" -- "1..*" userRating : creates
worldClock "1" -right- "1..*" userRating : \t is-saved-by \t
LocationsOptions "1" -down- "*" Location : contains
User "1..*" -right- "1" LocationsOptions: \t searches-through\t

@enduml
```


# OVERALL DESIGN CLASS DIAGRAM  

```plantuml
@startuml

class User{
username: String
--
getUser(): String
}

class userRating{
number: int
color: String
comment: String
--
canRate(): bool
showColor(): String 
showTime(): String
makeRating(number: int, color: String, comment: String): userRating
}

class LocationsOptions{
locationsList: Location ArrayList 
--
locationExists(): boolean
getLocation(): Location
makeNewLocation(): void
}

class Location {
name: String
allRatings: Int Linked List 
commentSection: String Linked List 
--
getRatingAve(): double
showComments(): Comment
}

class ratingTimer{
minutes: int
seconds: int
--
getTime(): String 
updateTimer: String
timeOver(): bool
}

class worldClock{
minutes: int
seconds: int
--
getTime(): String
updateTime(): void
}


User .down.> userRating
User .> LocationsOptions
userRating .right.> Location
LocationsOptions .down.> Location
userRating .down.> ratingTimer
worldClock .right.> userRating

@enduml
```

# Sequence diagrams

## Browse locations

```plantuml
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

# Report Busyness Sequence Diagram 

```plantuml
@startuml
actor Rater as rater 
participant " : User Interface" as ui
participant " : Controller" as controller
participant " : Location" as location 
participant " : LocationsOptions" as locOps 
participant " : userRating" as ratings 
participant " : worldClock" as clock 
participant " : ratingTimer" as timer 



rater -> ui  : select "Rate A Location"
ui -> controller : run timeOver()
controller -> timer : timeOver()
timer -> controller : return timeOver
controller -> ratings  : canRate()
ratings -> controller : return canRate()
alt canRate()

controller -> locOps :  get locationsList
locOps -> ui : return locationsList
ui ->  rater : display locationsList
rater -> ui : select a location
ui -> controller : run locationExists
controller -> locOps: locationExists

alt !locationExists()
locOps -> location : Execute __Add Location__ 
location -> controller : return location 
else locationExists()
locOps  -> location : getLocation()
location -> controller : return location 
end

controller -> ui : Open Textbox for User 
ui -> rater : Display Textbox to Rate
rater -> ui : Enter Rating Requirements
ui -> controller : Input into makeRating
controller -> ratings : makeRating(number: int, color: String, comment: String)


ratings -> timer : updateTime();
timer -> ui : getTime()
ui -> rater : Display "Time Until Next Rating"


else !canRate()
controller -> ui : No Rating Made 
ui -> rater : Display "Timer Not Yet Over"
end


@enduml
```

# Check Busyness Sequence Diagram

is user done viewing 
    yes 
        end 
    no 
        display locations 
        select desired location 
        is data available 
            yes 
                display overall crowd rating
            no 
                display history of ratings 
        overall crowd rating
        change  time period?
            yes 
                execute time period change
            no 
                add report?
                    yes 
                        execute report busyness
                    no  
                        still viewing?


```plantuml
@startuml
actor Viewer as viewer 
participant " : User Interface" as ui
participant " : Controller" as controller
participant " : Location" as location 
participant " : LocationsOptions" as locOps 
participant " : userRating" as ratings 
participant " : worldClock" as clock 
participant " : ratingTimer" as timer 

viewer -> ui : 
ui -> controller : display locations 
controller -> locOps :  get locationsList
locOps -> controller : return locationsList
controller -> ui : 
ui ->  rater : display locationsList

rater -> ui : select location 
