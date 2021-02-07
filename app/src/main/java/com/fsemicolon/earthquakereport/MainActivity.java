package com.fsemicolon.earthquakereport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
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



        ArrayList<Earthquake> earthquakesList = new ArrayList<>();


        earthquakesList.add(new Earthquake(7.2,"San Fransisco","Feb 2 2018"));

        earthquakesList.add(new Earthquake(6.1,"London","Sep 25 2018"));

        earthquakesList.add(new Earthquake(8.9,"Tokyo","Feb 14 2020"));

        earthquakesList.add(new Earthquake(9.6,"Paris","March 1 2015"));

        earthquakesList.add(new Earthquake(3.2,"Warsaw","June 12 2018"));

        earthquakesList.add(new Earthquake(2.7,"Delhi","Sep 10 2015"));

        earthquakesList.add(new Earthquake(9.5,"Berlin","April 2 2021"));


        //find the id for recyclerView

        mRecyclerView = findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Connect layoutManager to our recyclerView
        mRecyclerView.setLayoutManager(layoutManager);


        //Instantiate our Adapter
        mEarthquakeAdapter = new EarthquakeAdapter(earthquakesList);

        mRecyclerView.setHasFixedSize(true);

        // Connect the recyclerView to the Adapter


        mRecyclerView.setAdapter(mEarthquakeAdapter);


    }
}






















