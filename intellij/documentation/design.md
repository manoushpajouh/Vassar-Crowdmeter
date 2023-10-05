# Domain Model for Entire Program

```plantuml
@startuml

skin rose 

hide circle 
hide circle 

' classes 

class Location {
name
rating
}

class Comments {
username
comment
}

class ratingTimer{
minutes
seconds
}

class worldClock{
minutes
seconds
}

class userRating{
number
color
comment
}

class User{
username
}

class LocationsOptions{
locations
}


' associations 
userRating "1"  - "1" Location : \t describes \t
userRating "*" -- "1" ratingTimer : initiates/depends-on \t
User "1..*" -- "1..*" userRating : creates
worldClock "1" -right- "1..*" userRating : \t is saved by \t
LocationsOptions "1" -down- "*" Location : contains
Location "1" -- "*" Comments: contains

@enduml
```


# DESIGN CLASS DIAGRAM  

```plantuml
@startuml

class User{
username: String
--
...
}

class LocationsOptions{
locations : Location ArrayList 
--
getLocation() : Location
}

class Location {
name : String
rating : double
commentSection : String Linked List 
--
toString(): String
}

class ratingTimer{
minutes : int
seconds : int
--
getTime(): String 
updateTimer: String
}

class worldClock{
minutes : int
seconds : int
--
updateTime(): void
getTime(): String
}

class userRating{
number : int
color : String
comment : String
--
...
}


User .down.> userRating
userRating .right.> Location
LocationsOptions .down.> Location
userRating .down.> ratingTimer
worldClock .right.> userRating

@enduml
```


