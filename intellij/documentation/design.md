# OVERALL DOMAIN MODEL 
```plantuml
@startuml

skin rose 

hide circle 
hide circle 

' classes 

class Controller{
}

class LocationsLibrary{
locations 
}

class Location{
name
crowdRating
allRatings
allComments
}

class Rating{
number
comment
time
}

class Comment{
text 
time
}


' associations 

LocationsLibrary "1" -down- "0..*" Location : \t contains
Location "1" - "0..*" Rating : \t described by \t
Rating "1" - "0..*" Comment : \t described by \t


User "1..*" -left- "1" Controller: \t calls-on\t
User "1" - "0..*" Comment: \t writes \t
Controller "1" -- "1" LocationsLibrary: \t searches-through \t
User "1..*" -- "1..*" Rating : creates


@enduml
```


# OVERALL DESIGN CLASS DIAGRAM  

```plantuml
@startuml

class User{
main(String args[]): void
}

class Controller{
addCommentRatingToLoc(Comment comment, int number, IAddRatingsView view): void 
addRatingToLoc(int number, IAddRatingsView view): void 
completedRatings(): void 
getAllLocations(): List<Location>

}

class LocationsLibrary{
locations: Location ArrayList 
--
LocationsLibrary()
--
toString(): String
addLocation(String name): Location 
deleteLocation(Location l): void
searchByName(String searchInput): List<Location>
getLocations: List<Location>
}

class Location {
name: String
crowdRating: double
allRatings: List<Rating>
allComments: List<Comment>
--
Location(String name, double crowdRating)
Location(String name)
--
toString(): String
getName() : String
getComments() : List<Comment>
getRatingAve(): double
getRatingAveTime(int hours) : double 
updateRatingAve(): void
addRating(int ratingNumber): void 
addCommentRating(int rateNum, Comment newComment): void 
assignColor(): String 
toMap(): Map<String, Object>
fromMap(Map<String, Object> map): Location
}


class Rating{
number: int
comment: String
--
Rating(int number)
Rating(int number, String comment)
--
toString(): String 
getTime(): Date
toMap(): Map<String, Object> 
fromMap(Map<String, Object> map): Rating

}

class Comment{
text: String
time: Date
-- 
Comment(String text)
-- 
getText(): String 
getTime() : Date 
compareTo(Object e): int

}

' associations 
Rating "1..*"  - "1" Location : \t describes \t
User "1..*" -- "1..*" Rating : creates
LocationsLibrary "1" -down- "*" Location : contains
User "1..*" -right- "1" Controller: \t calls-on \t
Controller "1" - "1" LocationsLibrary: searches-through 
Rating "1" -left- "0..*" Comment: described-by
User "1" - "0..*" Comment: \t writes \t


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

# Add Location Sequence Diagram

```plantuml
@startuml
actor Viewer as viewer 
participant " : User Interface" as ui
participant " : Controller" as controller
participant " : Location" as location 
participant " : LocationsLibrary" as lib 

viewer -> ui: click button to add location 
ui -> controller: signal button has been clicked
controller -> ui : display add location fragment
ui -> viewer: display add location fragment 

viewer -> ui : Enter Name for Location 
viewer -> ui: Click Add Location Button 
ui -> controller : onClick()
controller -> location: make location: Location() 
location -> controller: return location

controller -> lib : add location to library: addLocation();
lib -> controller: return locations
controller -> ui : return locations


@enduml
```


# Report Busyness (for already existing location) Sequence Diagram

```plantuml
@startuml
actor Rater as rater 

participant " : User Interface" as ui
participant " : Controller" as controller
participant " : Location" as location 


rater -> ui : search for location 
ui -> controller: Execute __Browse Locations__
rater -> ui: choose location 
ui -> controller: notify that location was chosen 
controller -> ui : display add rating fragment 
ui -> rater : display rating boxes 
rater -> ui : fill in rating requirements
ui -> controller: notify that requirements have been filled in
controller -> location : addCommentRating(number: int, comment: String)
controller -> location : addRating(number: int)

@enduml
```

# Check Busyness Sequence Diagram

```plantuml
@startuml
actor Viewer as viewer 
participant " : User Interface" as ui
participant " : Controller" as controller
participant " : LocationsLibrary" as lib 
participant " : Location" as location 
participant " : Rating" as ratings 

viewer -> ui : hit button to search for location 
ui -> controller : notify button has been hit 
controller -> ui : Execute __Browse Locations__
ui -> viewer : display locations 
viewer -> ui : click view rating button 
ui -> controller : notify button for location has been hit

controller -> lib : searchByName(location name input)
lib -> location : getRatingAve()
location -> controller : return crowdRatingAve


controller -> ui : return location.crowdRating()
ui -> viewer : display location.crowdRating()

@enduml
```
