package com.example.myevent.Model;

public class Event {

    private String Ename;
    private String place;
    private String type;
    private String date;
    private String people;
    private String sponsors;


    public Event() {
    }


    public String getEname() {
        return Ename;
    }

    public String getPlace() {
        return place;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getPeople() {
        return people;
    }

    public String getSponsors() {
        return sponsors;
    }


    public void setEname(String ename) {
        Ename = ename;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public void setSponsors(String sponsors) {
        this.sponsors = sponsors;
    }
}
