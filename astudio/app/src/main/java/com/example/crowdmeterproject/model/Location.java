package com.example.crowdmeterproject.model;

import java.util.ArrayList;
import java.util.List;

public class Location {
    public String name; // name of location
    int crowdRating; // how busy is it, 1-5?

    public Location(String name, int crowdRating){
        this.name = name;
        this.crowdRating = crowdRating;
    }

    // to print a location, display its name and its crowd rating
    public String toString(){
        return "Location name: " + name + "\nCrowd rating: " + crowdRating;
    }
    public String getName(){
        return this.name;
    }
}
