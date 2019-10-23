package com.brian.learnmaoriapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ColoursActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colours);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Intent.EXTRA_TEXT);
        Toast.makeText(getBaseContext(),message,Toast.LENGTH_LONG).show();

        ArrayList<Colour> colourNames = GetColours();
        ColourAdapter itemsAdapter = new ColourAdapter(this, R.layout.list_view_color_item, colourNames);

        ListView tempView = (ListView) findViewById(R.id.color_list);
        tempView.setAdapter(itemsAdapter);

        tempView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final ImageView playImgaeView = (ImageView) view.findViewById(R.id.image_view_play);

                ScaleAnimation zoom_in = new ScaleAnimation(1f, 1.2f, 1f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                zoom_in.setDuration(300);     // animation duration in milliseconds
                playImgaeView.startAnimation(zoom_in);

                zoom_in.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation arg0) {
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void onAnimationRepeat(Animation arg0) {
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void onAnimationEnd(Animation arg0) {
                        ScaleAnimation zoom_out = new ScaleAnimation
                                (1.2f, 1f, 1.2f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                        zoom_out.setDuration(300);
                        playImgaeView.startAnimation(zoom_out);
                    }
                });

            }
        });
    }


    private Map<Integer, String> GetColorNames(){
        Map<Integer, String> names = new LinkedHashMap<Integer, String>();
        names.put(1, "Yellow");
        names.put(2, "Orange");
        names.put(3, "Red");
        names.put(4, "Pink");
        names.put(5, "Purple");
        names.put(6, "Blue");
        names.put(7, "Green");
        names.put(8, "Brown");
        names.put(9, "Grey");
        names.put(10, "White");
        names.put(11, "Black");
        return names;
    }
    private Map<Integer, String> GetMaoriColorNames(){
        Map<Integer, String> names = new LinkedHashMap<Integer, String>();
        names.put(1, "Kowhai");
        names.put(2, "Karaka");
        names.put(3, "Whero");
        names.put(4, "Mawhero");
        names.put(5, "Tawa");
        names.put(6, "Kikorangi");
        names.put(7, "Kakariki");
        names.put(8, "Parauri");
        names.put(9, "Kiwikiwi");
        names.put(10, "Ma");
        names.put(11, "Mangu");
        return names;
    }
    ArrayList<Colour> GetColours(){
        ArrayList<Colour> colourArrayList = new ArrayList<Colour>();
        Map<Integer, String> maoriColorNames = GetMaoriColorNames();
        Map<Integer, String> englishColorNames = GetColorNames();
        for (int i = 1; i <= maoriColorNames.size(); i++){
            int id = i;
            String maoriTranslation = maoriColorNames.get(i);
            String englishTranslation = englishColorNames.get(i);
            String audio = "audio_" + englishColorNames.get(i).toLowerCase();
            Colour member = new Colour(id,englishTranslation, maoriTranslation, audio);
            colourArrayList.add(member);
        }
        return colourArrayList;
    }
}
