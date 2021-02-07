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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ArrayList<EarthquakeDetails> earthquakeDetails = new ArrayList<>();

        earthquakeDetails.add(new EarthquakeDetails("San Fransisco"));
        earthquakeDetails.add(new EarthquakeDetails("London"));
        earthquakeDetails.add(new EarthquakeDetails("Tokyo"));
        earthquakeDetails.add(new EarthquakeDetails("Paris"));
        earthquakeDetails.add(new EarthquakeDetails("Warsaw"));
        earthquakeDetails.add(new EarthquakeDetails("Delhi"));
        earthquakeDetails.add(new EarthquakeDetails("Berlin"));





        //find the id for recyclerView

        mRecyclerView = findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Connect layoutManager to our recyclerView
        mRecyclerView.setLayoutManager(layoutManager);


        //Instantiate our Adapter
        mEarthquakeAdapter = new EarthquakeAdapter(earthquakeDetails);

        mRecyclerView.setHasFixedSize(true);

        // Connect the recyclerView to the Adapter


        mRecyclerView.setAdapter(mEarthquakeAdapter);


    }
}






















