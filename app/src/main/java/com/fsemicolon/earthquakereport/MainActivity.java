package com.fsemicolon.earthquakereport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements EarthquakeAdapter.ListItemClickListener, LoaderManager.LoaderCallbacks<ArrayList<Earthquake>> {

    /**
     * STEP 3: CREATE A LINEAR LAYOUT MANAGER IN ORDER TO WIRE UP THE ENTIRE RECYCLERVIEW
     */

    private RecyclerView mRecyclerView;

    private EarthquakeAdapter mEarthquakeAdapter;

    private Intent mWebPageIntent;

    ArrayList<Earthquake> earthquakesList;

    private static final String USGS_EARTHQUAKE_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";


    ArrayList<String> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportLoaderManager().initLoader(0,null,this);
        //find the id for recyclerView

        mRecyclerView = findViewById(R.id.recycler_view);




    }


    @Override
    public void onListItemClick(int position) {

        Earthquake currentEarthQuake = earthquakesList.get(position);

        String urlString = currentEarthQuake.getUrlString();

        mWebPageIntent.setData(Uri.parse(urlString));

        startActivity(mWebPageIntent);

    }

    public void updateUI(ArrayList<Earthquake> data)
    {

        mEarthquakeAdapter = new EarthquakeAdapter(data,this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Connect layoutManager to our recyclerView
        mRecyclerView.setLayoutManager(layoutManager);



        mRecyclerView.setHasFixedSize(true);

        // Connect the recyclerView to the Adapter


        mRecyclerView.setAdapter(mEarthquakeAdapter);

        //We are setting the type of our intent

        mWebPageIntent = new Intent(Intent.ACTION_VIEW);

    }

    @NonNull
    @Override
    public Loader<ArrayList<Earthquake>> onCreateLoader(int id, @Nullable Bundle args) {
        return new EarthquakeLoader(MainActivity.this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Earthquake>> loader, ArrayList<Earthquake> data) {

        updateUI(data);

    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Earthquake>> loader) {

    }


}






















