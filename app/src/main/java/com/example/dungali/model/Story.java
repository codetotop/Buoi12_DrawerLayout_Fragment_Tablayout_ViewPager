package com.example.dungali.model;

import java.io.Serializable;

/**
 * Created by Dung Ali on 6/22/2017.
 */

public class Story implements Serializable {

    Integer pictureProfile;
    String nameStory;

    public Story() {
    }

    public Story(Integer pictureProfile, String nameStory) {
        this.pictureProfile = pictureProfile;
        this.nameStory = nameStory;
    }

    public Integer getPictureProfile() {
        return pictureProfile;
    }

    public void setPictureProfile(Integer pictureProfile) {
        this.pictureProfile = pictureProfile;
    }

    public String getNameStory() {
        return nameStory;
    }

    public void setNameStory(String nameStory) {
        this.nameStory = nameStory;
    }
}

