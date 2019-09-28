package com.example.myevent.Model;

public class Confirm {


    private String Description;
    private String Price;
    private String ContactNumber;

    public Confirm(String description, String price, String contactNumber) {
        Description = description;
        Price = price;
        ContactNumber = contactNumber;
    }

    public Confirm() {

    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }


}
