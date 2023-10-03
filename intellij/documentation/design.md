# Domain Model 

```plantuml
@startuml

skin rose 

hide circle 
hide circle 

' classes 

class Location {
name
rating
comments
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




' associations 
userRating - Location : describes
userRating -- ratingTimer : depends-on


@enduml
```


# SEQUENCE DIAGRAM 
