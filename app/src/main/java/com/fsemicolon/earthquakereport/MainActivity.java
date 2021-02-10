package com.fsemicolon.earthquakereport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements EarthquakeAdapter.ListItemClickListener {

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


        new EarthquakeAsyncTask().execute(USGS_EARTHQUAKE_URL);

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

    public void updateUI(String jsonResponse)
    {

        earthquakesList = QueryUtils.extractEarthquakes(jsonResponse);
        //Instantiate our Adapter
        mEarthquakeAdapter = new EarthquakeAdapter(earthquakesList,this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Connect layoutManager to our recyclerView
        mRecyclerView.setLayoutManager(layoutManager);



        mRecyclerView.setHasFixedSize(true);

        // Connect the recyclerView to the Adapter


        mRecyclerView.setAdapter(mEarthquakeAdapter);

        //We are setting the type of our intent

        mWebPageIntent = new Intent(Intent.ACTION_VIEW);

    }

    public class EarthquakeAsyncTask extends AsyncTask<String,Void,String>
    {

        @Override
        protected String doInBackground(String... urls) {

            String urlString = urls[0];

            if (urlString!=null && !(TextUtils.isEmpty(urlString)))
            {
                try {
                    URL url = new URL(urlString);

                    String jsonResponse = QueryUtils.makeHttpRequest(url);

                    return jsonResponse;
                } catch (MalformedURLException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(String jsonResponse) {

            if (jsonResponse!=null&&!(TextUtils.isEmpty(jsonResponse)))
            {
                updateUI(jsonResponse);


            }
        }
    }
}






















