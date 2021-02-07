package com.fsemicolon.earthquakereport;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class EarthquakeAdapter  {

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

        /**
         * Let's define a bind method in order to add the data to our placeTextView
         */

        public void bind(String place)
        {
            placeTextView.setText(place);
        }
    }


}
