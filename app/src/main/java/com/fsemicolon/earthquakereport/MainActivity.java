package com.fsemicolon.earthquakereport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements EarthquakeAdapter.ListItemClickListener {

    /**
     * STEP 3: CREATE A LINEAR LAYOUT MANAGER IN ORDER TO WIRE UP THE ENTIRE RECYCLERVIEW
     */

    private RecyclerView mRecyclerView;

    private EarthquakeAdapter mEarthquakeAdapter;

    private Intent mWebPageIntent;

    ArrayList<Earthquake> earthquakesList;

    ArrayList<String> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        earthquakesList = QueryUtils.extractEarthquakes();

        //find the id for recyclerView

        mRecyclerView = findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Connect layoutManager to our recyclerView
        mRecyclerView.setLayoutManager(layoutManager);


        //Instantiate our Adapter
        mEarthquakeAdapter = new EarthquakeAdapter(earthquakesList,this);

        mRecyclerView.setHasFixedSize(true);

        // Connect the recyclerView to the Adapter


        mRecyclerView.setAdapter(mEarthquakeAdapter);

        //We are setting the type of our intent

        mWebPageIntent = new Intent(Intent.ACTION_VIEW);


    }


    @Override
    public void onListItemClick(int position) {

        Earthquake currentEarthQuake = earthquakesList.get(position);

        String urlString = currentEarthQuake.getUrlString();

        mWebPageIntent.setData(Uri.parse(urlString));

        startActivity(mWebPageIntent);



    }
}






















