package com.fsemicolon.earthquakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities = new ArrayList<>();

        cities.add("San Fransisco");
        cities.add("London");
        cities.add("Tokyo");
        cities.add("Paris");
        cities.add("Warsaw");
        cities.add("Delhi");
        cities.add("Berlin");
    }
}