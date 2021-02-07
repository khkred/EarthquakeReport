package com.fsemicolon.earthquakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.loader.app.LoaderManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * STEP 2: EXTEND THE ADAPTER CLASS IN OUR EarthquakeAdapter
 */

public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeAdapter.EarthquakeViewHolder> {


    ArrayList<EarthquakeDetails> mPlaces;


    //We need to create a constructor in order to get the cities from our Main Activity

    public EarthquakeAdapter(ArrayList<EarthquakeDetails> places)
    {
        mPlaces = places;
    }

    //Here are we going to implement the onCreateViewHolder method


    @NonNull
    @Override
    public EarthquakeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //First step is to get the context

        Context context = parent.getContext();

        //Next step is to call the Layout Inflater for getting the view

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.list_item,parent,false);

        //Finally we have to return an EarthquakeViewHolder

        return new EarthquakeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EarthquakeViewHolder holder, int position) {



        holder.bind(position);

    }

    @Override
    public int getItemCount() {

        int size =mPlaces.size();
        return
                mPlaces.size();
    }

    /**
     * STEP 1: DEFINE A VIEW HOLDER CLASS
     */
    class EarthquakeViewHolder extends RecyclerView.ViewHolder
    {
        TextView placeTextView;


        public EarthquakeViewHolder(View itemView)
        {
            super(itemView);

            placeTextView = itemView.findViewById(R.id.location_text_view);
        }

        //Let's define a bind method in order to add the data to our placeTextView

        public void bind(int position)
        {
            String city = mPlaces.get(position).getLocation();

            placeTextView.setText(city);

        }
    }


}
