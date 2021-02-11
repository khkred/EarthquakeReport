package com.fsemicolon.earthquakereport;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class EarthquakeLoader extends AsyncTaskLoader<ArrayList<Earthquake>> {

    private static final String USGS_EARTHQUAKE_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";


    public EarthquakeLoader(Context context)
    {
        super(context);

    }


    @Nullable
    @Override
    public ArrayList<Earthquake> loadInBackground() {

        //First We'll convert the String into a URL Object

        URL url;

        HttpURLConnection httpURLConnection = null;

        InputStream inputStream = null;

        try {
             url = new URL(USGS_EARTHQUAKE_URL);

            httpURLConnection = (HttpURLConnection)url.openConnection();

            httpURLConnection.setReadTimeout(10000);

            httpURLConnection.setConnectTimeout(15000);

            httpURLConnection.setRequestMethod("GET");

            httpURLConnection.connect(); // At this point the connection is established

            /**
             * Now that the connection is established we need to get the data from the internet into our jsonString
             * For that we will use InputStream, BufferedReader and StringBuilder
             */

            //Get the inputStream

            inputStream = httpURLConnection.getInputStream();

            //First let's read the data from inputStream

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);


            //The data we receive from inputStream is in byteSize code, we have to convert those bits into characters

            //So we use a BufferReader

            StringBuilder stringBuilder = new StringBuilder();

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


            //First let's read the line from bufferedReader

            String line = bufferedReader.readLine();


            while (line!=null)
            {
                stringBuilder.append(line);

                line = bufferedReader.readLine();
            }

            String jsonString = stringBuilder.toString();

            /**
             * Now that we have the jsonString we can convert it into ArrayList of earthquake objects
             */

            ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes(jsonString);

            return earthquakes;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;


    }
}
