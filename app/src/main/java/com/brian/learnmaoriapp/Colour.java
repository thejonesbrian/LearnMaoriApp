package com.brian.learnmaoriapp;

/**
 * Created by brian on 25/06/2017.
 */

public class Colour {
    private int mId;
    private String mEnglishTranslation;
    private String mMaoriTranslation;
    private String mAudio;

    //Properties

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmEnglishTranslation() {
        return mEnglishTranslation;
    }

    public void setmEnglishTranslation(String mEnglishTranslation) {
        this.mEnglishTranslation = mEnglishTranslation;
    }

    public String getmMaoriTranslation() {
        return mMaoriTranslation;
    }

    public void setmMaoriTranslation(String mMaoriTranslation) {
        this.mMaoriTranslation = mMaoriTranslation;
    }

    public String getmAudio() {
        return mAudio;
    }

    public void setmAudio(String mAudio) {
        this.mAudio = mAudio;
    }
    public Colour(int id, String englishTranslation, String maoriTranslation, String audio){
        this.mId = id;
        this.mEnglishTranslation = englishTranslation;
        this.mMaoriTranslation = maoriTranslation;
        this.mAudio = audio;
    }
}
