package com.example.myevent.Model;

public class CustomerPost {

    private String Name;
    private String Description;
    private String Image;

    public CustomerPost(String name, String description, String image) {
        Name = name;
        Description = description;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public CustomerPost() {

    }
}
