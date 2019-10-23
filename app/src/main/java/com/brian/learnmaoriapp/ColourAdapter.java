package com.brian.learnmaoriapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian on 25/06/2017.
 */

public class ColourAdapter extends ArrayAdapter {
    MediaPlayer mediaPlayer;
    int mLayoutID;
    ArrayList<Colour> mColours;
    Context mContext;
    public ColourAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);
        mLayoutID = resource;
        mColours = objects;
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Get a reference to the current ListView item
        View currentListViewItem = convertView;

        // Check if the existing view is being reused, otherwise inflate the view
        if (currentListViewItem == null) {
            currentListViewItem = LayoutInflater.from(getContext()).inflate(mLayoutID, parent, false);
        }
        //Get the Number object for the current position
        Colour currentNumber = mColours.get(position);

        TextView maoriTextView = (TextView) currentListViewItem.findViewById(R.id.text_view_maori_word);
        maoriTextView.setText(currentNumber.getmMaoriTranslation());

        TextView englishTextView = (TextView) currentListViewItem.findViewById(R.id.text_view_eng_word);
        englishTextView.setText(currentNumber.getmEnglishTranslation());

        //Gettting the audio resource id for the current Number object
        final String audio = currentNumber.getmAudio();
        final ImageView play = (ImageView) currentListViewItem.findViewById(R.id.image_view_play);

        //Setting the image click handler
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Operations to perform when the play ImageView is clicked
                int i = mContext.getResources().getIdentifier(
                        audio, "raw",
                        mContext.getPackageName());
                //Using MediaPlayer to play the audio file
                if (mediaPlayer != null)
                    mediaPlayer.release();
                mediaPlayer = MediaPlayer.create(mContext, i);
                mediaPlayer.start();
                Animation animation1 = new AlphaAnimation(0.3f, 1.0f);
                animation1.setDuration(800);
                play.startAnimation(animation1);
            }
        });

        return currentListViewItem;
    }
}
