package com.brian.learnmaoriapp;

import java.util.ArrayList;

/**
 * Created by brian on 17/06/2017.
 */

public class Numbers {
    //Attributes
    private int mId;
    private String mIcon;
    private String mMaoriTranslation;
    private String mAudio;

    //Properties
    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        this.mIcon = icon;
    }

    public String getAudio() {
        return mAudio;
    }

    public void setAudio(String audio) {
        this.mAudio = audio;
    }

    public String getMaoriTranslation() {
        return mMaoriTranslation;
    }

    public void setMaoriTranslation(String maoriTranslation) {
        this.mMaoriTranslation = maoriTranslation;
    }

    //Constructor
    public Numbers(int id, String icon, String maoriTranslation, String audio) {
        this.mId = id;
        this.mIcon = icon;
        this.mMaoriTranslation = maoriTranslation;
        this.mAudio = audio;
    }
}
