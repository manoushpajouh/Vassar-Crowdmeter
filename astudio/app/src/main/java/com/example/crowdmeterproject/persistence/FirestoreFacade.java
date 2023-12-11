package com.example.crowdmeterproject.persistence;

import com.example.crowdmeterproject.model.Location;
import com.example.crowdmeterproject.model.LocationsLibrary;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FirestoreFacade implements IPersistenceFacade{
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String LOCATIONS_LIBRARY = "locations";

    /**
     * Saves a location to firestore storage.
     */
    @Override
    public void saveLocation(Location location) {
        CollectionReference cref = this.db.collection(LOCATIONS_LIBRARY);
        DocumentReference dref = cref.document(location.getName());

        dref.set(location.toMap());
    }

    /**
     * Updates the rating average of a location stored in firestore storage.
     * @param average
     * @param location
     */
    @Override
    public void updateRatingAverage(double average, Location location) {
        CollectionReference cref = this.db.collection(LOCATIONS_LIBRARY);
        DocumentReference dref = cref.document(location.getName());

        dref.set(location.toMap(), SetOptions.merge());
    }

    /**
     * Deletes a location from firestore storage.
     * @param location
     */
    @Override
    public void deleteLocation(Location location) {
        DocumentReference dref = db.document("locations/" + location.getName());
        dref.delete();
    }
    /**
     * Retrieves the locations library from firestore storage and recreates it.
     */
    @Override
    public void retrieveLocationsLibrary(Listener listener) {
        LocationsLibrary lib = new LocationsLibrary();
        List<Location> locations = new ArrayList<>();

        Task<QuerySnapshot> task = this.db.collection(LOCATIONS_LIBRARY).get();

        task.addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot qsnap) {
                for (DocumentSnapshot dsnap : qsnap){
                    Map<String, Object> mapData = dsnap.getData();
                    Location location = Location.fromMap(mapData);
                    locations.add(location);
                }
                lib.setLocations(locations);
                listener.onLibRecieved(lib);
            }
        });
    }
}
