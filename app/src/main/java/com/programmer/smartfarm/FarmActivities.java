package com.programmer.smartfarm;

public class FarmActivities {
    private int image;

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public FarmActivities(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    private String title;
    private String description;


}
