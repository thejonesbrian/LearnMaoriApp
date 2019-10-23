package com.brian.learnmaoriapp;

/**
 * Created by brian on 21/06/2017.
 */

public class Family {
    //Attributes
    private int fId;
    private String fIcon;
    private String fMaoriTranslation;
    private String fEnglishWord;
    private String fAudio;

    //Properties
    public int getfId(){
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getfIcon() {
        return fIcon;
    }

    public void setfIcon(String fIcon) {
        this.fIcon = fIcon;
    }

    public String getfAudio() {
        return fAudio;
    }

    public void setfAudio(String fAudio) {
        this.fAudio = fAudio;
    }

    public String getfMaoriTranslation() {
        return fMaoriTranslation;
    }

    public void setfMaoriTranslation(String fMaoriTranslation) {
        this.fMaoriTranslation = fMaoriTranslation;
    }

    public String getfEnglishWord() {
        return fEnglishWord;
    }

    public void setfEnglishWord(String fEnglishWord) {
        this.fEnglishWord = fEnglishWord;
    }

    public Family(int id, String icon, String maoriTranslation, String englishWord, String audio){
        this.fId = id;
        this.fIcon = icon;
        this.fMaoriTranslation  = maoriTranslation;
        this.fEnglishWord = englishWord;
        this.fAudio = audio;
    }
}
