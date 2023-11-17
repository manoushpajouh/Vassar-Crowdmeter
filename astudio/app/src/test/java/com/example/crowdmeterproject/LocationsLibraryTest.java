package com.example.crowdmeterproject;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.crowdmeterproject.model.Location;
import com.example.crowdmeterproject.model.LocationsLibrary;

/**
 * Test class for LocationsLibrary methods.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LocationsLibraryTest {
    @Test
    public void addTest() {
        LocationsLibrary l = new LocationsLibrary();
        assertEquals(0, l.getLocations().size());

        l.addLocation("test", 0);
        assertEquals(1, l.getLocations().size());
    }

    @Test
    public void searchTest() {
        LocationsLibrary l = new LocationsLibrary();
        l.addLocation("test", 0);

        assertEquals("Location name: test\nCrowd rating: 0", (l.searchByName("test")).toString());
    }
}