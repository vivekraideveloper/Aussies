package com.vijayjaidewan01vivekrai.aussies;

import com.google.firebase.database.Exclude;

/**
 * Created by MR VIVEK RAI on 02-06-2018.
 */

public class Upload {

    private String name;
    private String imageUrl;
    private String mkey;
    private String videoId;

    public Upload() {
    }

    public Upload(String name, String imageUrl, String videoId) {
        if (name.trim() == ""){
            name = "No Name";
        }
        this.name = name;
        this.imageUrl = imageUrl;
        this.videoId = videoId;
    }

    public String getName() {
        return name;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Exclude
    public String getMkey() {
        return mkey;
    }

    @Exclude
    public void setMkey(String mkey) {
        this.mkey = mkey;
    }
}
