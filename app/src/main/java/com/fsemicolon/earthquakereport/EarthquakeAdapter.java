package com.fsemicolon.earthquakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * STEP 2: EXTEND THE ADAPTER CLASS IN OUR EarthquakeAdapter
 */

public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeAdapter.EarthquakeViewHolder> {

    private final ListItemClickListener mOnItemClickListener;


    private ArrayList<Earthquake> mEarthquakesList;

    //We need to create a constructor in order to get the cities from our Main Activity

    /**
     * STEP 5: WE ARE IMPLEMENTING CLICK FUNCTIONALITY INTO OUR RECYCLERVIEW
     */

    public interface ListItemClickListener
    {
        public void onListItemClick(int position);
    }

    public EarthquakeAdapter(ArrayList<Earthquake> earthquakesList,ListItemClickListener onItemClickListener) {

        mEarthquakesList = earthquakesList;

        mOnItemClickListener = onItemClickListener;
    }

    //Here are we going to implement the onCreateViewHolder method


    @NonNull
    @Override
    public EarthquakeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //First step is to get the context

        Context context = parent.getContext();

        //Next step is to call the Layout Inflater for getting the view

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.list_item, parent, false);

        //Finally we have to return an EarthquakeViewHolder

        return new EarthquakeViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull EarthquakeViewHolder holder, int position) {


        holder.bind(position);

    }

    @Override
    public int getItemCount() {

        return mEarthquakesList.size();
    }

    /**
     * STEP 1: DEFINE A VIEW HOLDER CLASS
     */
    class EarthquakeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        GradientDrawable magnitudeCircle;
        TextView locationOffsetTextView;

        TextView primaryLocationTextView;

        TextView magnitudeTextView;

        TextView dateTextView;

        TextView timeTextView;

        Context mContext;

        public EarthquakeViewHolder(View itemView) {
            super(itemView);

            mContext = itemView.getContext();

            locationOffsetTextView = itemView.findViewById(R.id.location_offset_text_view);

            primaryLocationTextView = itemView.findViewById(R.id.primary_location_text_view);

            magnitudeTextView = itemView.findViewById(R.id.magnitude_text_view);

            dateTextView = itemView.findViewById(R.id.date_text_view);

            timeTextView = itemView.findViewById(R.id.time_text_view);


            // We are setting the background for our MagnitudeTextView
            magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

            itemView.setOnClickListener(this);


        }


        //Let's define a bind method in order to add the data to our placeTextView

        public void bind(int position) {
            Earthquake currentEarthquake = mEarthquakesList.get(position);

            double magnitude = currentEarthquake.getMagnitude();

            DecimalFormat decimalFormat = new DecimalFormat("0.0");

            String magString = decimalFormat.format(magnitude);

            magnitudeTextView.setText(magString);


            String location = currentEarthquake.getLocation();

            String output[] = location.split("f", 2);

            locationOffsetTextView.setText(output[0] + "f");

            primaryLocationTextView.setText(output[1]);


            String date = getCurrentDate(currentEarthquake.getTimeInMilliSeconds());

            dateTextView.setText(date);

            String time = getCurrentTime(currentEarthquake.getTimeInMilliSeconds());

            timeTextView.setText(time);

            int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

            magnitudeCircle.setColor(magnitudeColor);

        }

        public String getCurrentDate(long timeInMilliSeconds) {


            Date dateObject = new Date(timeInMilliSeconds);

            SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");

            return dateFormat.format(dateObject);

        }


        public String getCurrentTime(long timeInMilliSeconds) {
            Date dateObject = new Date(timeInMilliSeconds);

            SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");


            return dateFormat.format(dateObject);
        }


        private int getMagnitudeColor(double magnitude) { int magnitudeColorResourceId;
            int magnitudeFloor = (int) Math.floor(magnitude); switch (magnitudeFloor) {
                case 0:
                case 1:
                    magnitudeColorResourceId = R.color.magnitude1;
                    break;
                case 2:
                    magnitudeColorResourceId = R.color.magnitude2;
                    break;
                case 3:
                    magnitudeColorResourceId = R.color.magnitude3;
                    break;
                case 4:
                    magnitudeColorResourceId = R.color.magnitude4;
                    break;
                case 5:
                    magnitudeColorResourceId = R.color.magnitude5;
                    break;
                case 6:
                    magnitudeColorResourceId = R.color.magnitude6;
                    break;
                case 7:
                    magnitudeColorResourceId = R.color.magnitude7;
                    break;
                case 8:
                    magnitudeColorResourceId = R.color.magnitude8;
                    break;
                case 9:
                    magnitudeColorResourceId = R.color.magnitude9;
                    break;
                default:
                    magnitudeColorResourceId = R.color.magnitude10plus;
                    break;
            }
            return ContextCompat.getColor(mContext, magnitudeColorResourceId);
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();

            mOnItemClickListener.onListItemClick(position);

        }
    }
}













