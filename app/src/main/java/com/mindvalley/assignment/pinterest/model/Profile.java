package com.mindvalley.assignment.pinterest.model;

import java.util.ArrayList;

/**
 * Created by jk035766 on 1/30/17.
 */

public class Profile {

    private String name;
    private int likes;
    private String imageUrl;
    private ArrayList<String> categories;

    public Profile(){
    }

    public Profile(String name, int likes, String imageUrl, ArrayList<String> categories) {
        this.name = name;
        this.likes = likes;
        this.imageUrl = imageUrl;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }
}
