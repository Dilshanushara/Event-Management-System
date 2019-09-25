package com.example.myevent.Model;

public class EventPlanner {
    private String Name;
    private String Email;
    private String Phone;
    private String Age;
    private String Description;
    private String Password;

    public EventPlanner(String name, String email, String phone, String age, String description, String password) {
        Name = name;
        Email = email;
        Phone = phone;
        Age = age;
        Description = description;
        Password = password;
    }

    public EventPlanner() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
