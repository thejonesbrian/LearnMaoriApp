package com.brian.learnmaoriapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static com.brian.learnmaoriapp.R.id.parent;

public class NumbersActivity extends AppCompatActivity {
    NumberAdaptor itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Intent.EXTRA_TEXT);
        Toast.makeText(getBaseContext(),message,Toast.LENGTH_LONG).show();
        ArrayList<Numbers> numbers = GetNumbers();

        itemsAdapter = new NumberAdaptor(this,
                R.layout.list_view_number_item,
                numbers);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        //Adding Zoom animation to the Play Button to provide emphasis
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

    private Map<Integer, String> GetMaoriDigits() {
        Map<Integer, String> words = new LinkedHashMap<Integer, String>();
        words.put(1, "Tahi");
        words.put(2, "Rua");
        words.put(3, "Toru");
        words.put(4, "Wha");
        words.put(5, "Rima");
        words.put(6, "Ono");
        words.put(7, "Whitu");
        words.put(8, "Waru");
        words.put(9, "Iwa");
        words.put(10, "Tekau");
        return words;
    }

    ArrayList<Numbers> GetNumbers() {
        ArrayList<Numbers> numbersArrayList = new ArrayList<Numbers>();
        Map<Integer, String> words = GetMaoriDigits();
        for (int i = 1; i <= words.size(); i++) {
            int id = i;
            String maoriTranslation = words.get(i);
            String icon = "icon" + id;
            String audio = "audio_" + id;
            Numbers n = new Numbers(id, icon, maoriTranslation, audio);
            numbersArrayList.add(n);
        }

        return numbersArrayList;
    }



}
