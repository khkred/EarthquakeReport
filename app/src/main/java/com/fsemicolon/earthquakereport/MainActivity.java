package com.fsemicolon.earthquakereport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * STEP 3: CREATE A LINEAR LAYOUT MANAGER IN ORDER TO WIRE UP THE ENTIRE RECYCLERVIEW
     */

    private RecyclerView mRecyclerView;

    private EarthquakeAdapter mEarthquakeAdapter;


    ArrayList<String> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities = new ArrayList<String>();

        cities.add("San Fransisco");
        cities.add("London");
        cities.add("Tokyo");
        cities.add("Paris");
        cities.add("Warsaw");
        cities.add("Delhi");
        cities.add("Berlin");

        //find the id for recyclerView

        mRecyclerView = findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Connect layoutManager to our recyclerView
        mRecyclerView.setLayoutManager(layoutManager);


        //Instantiate our Adapter
        mEarthquakeAdapter = new EarthquakeAdapter(cities);

        mRecyclerView.setHasFixedSize(true);

        // Connect the recyclerView to the Adapter


        mRecyclerView.setAdapter(mEarthquakeAdapter);


    }
}






















