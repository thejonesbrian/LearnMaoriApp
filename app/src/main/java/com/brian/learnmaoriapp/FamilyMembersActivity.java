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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Intent.EXTRA_TEXT);
        Toast.makeText(getBaseContext(),message,Toast.LENGTH_LONG).show();

        ArrayList<Family> familyNames = GetFamilys();
        FamilyAdapter itemsAdapter = new FamilyAdapter(this, R.layout.list_view_family_item, familyNames);

        ListView tempView = (ListView) findViewById(R.id.family_list);
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
    private Map<Integer, String> GetMaoriFamilyNames(){
        Map<Integer, String> names = new LinkedHashMap<Integer, String>();
        names.put(1, "Pāpā"); //father
        names.put(2, "Whaea"); //Mother
        names.put(3, "Wahine"); //Wife
        names.put(4, "Tāne"); //Husband
        names.put(5, "Tamiti"); //Child
        names.put(6, "Tamariki"); //Children
        names.put(7, "Tamāhine"); //Daughter
        names.put(8, "Tama"); //Son
        names.put(9, "Tungāne"); //Brother
        names.put(10, "Tuahine"); //Sister
        names.put(11, "Tipuna wahine"); //Grandmother
        names.put(12, "Tupuna tāne"); //Grandfather
        names.put(13, "Kotiro"); //Girl
        names.put(14, "Pepi"); //Baby
        return names;
    }
    private Map<Integer, String> GetEnglishFamilyNames(){
        Map<Integer, String> eNames = new LinkedHashMap<Integer, String>();
        eNames.put(1, "Father");
        eNames.put(2, "Mother");
        eNames.put(3, "Wife");
        eNames.put(4, "Husband");
        eNames.put(5, "Child");
        eNames.put(6, "Children");
        eNames.put(7, "Daughter");
        eNames.put(8, "Son");
        eNames.put(9, "Brother");
        eNames.put(10, "Sister");
        eNames.put(11, "Grandmother");
        eNames.put(12, "Grandfather");
        eNames.put(13, "Girl");
        eNames.put(14, "Baby");
        return eNames;
    }
    ArrayList<Family> GetFamilys(){
        ArrayList<Family> familysArraylist = new ArrayList<Family>();
        Map<Integer, String> maoriFamilyNames = GetMaoriFamilyNames();
        Map<Integer, String> englishFamilyNames = GetEnglishFamilyNames();
        for (int i = 1; i <= maoriFamilyNames.size(); i++){
            int id = i;
            String maoriTranslation = maoriFamilyNames.get(i);
            String englishTranslation = englishFamilyNames.get(i);
            String icon = "icon_" + englishFamilyNames.get(i).toLowerCase();
            String audio = "audio_" + englishFamilyNames.get(i).toLowerCase();
            Family member = new Family(id,icon,maoriTranslation,englishTranslation,audio);
            familysArraylist.add(member);
        }
        return familysArraylist;
    }
}
