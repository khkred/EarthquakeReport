package com.fsemicolon.earthquakereport;

public class Earthquake {

    private double mMagnitude;

    private String mLocation;

    private long mTimeInMilliSeconds;

    private String mUrlString;


    public Earthquake(double magnitude, String location, long timeInMilliSeconds, String urlString) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliSeconds = timeInMilliSeconds;
        mUrlString = urlString;
    }

    public String getUrlString() {
        return mUrlString;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliSeconds() {
        return mTimeInMilliSeconds;
    }


}
