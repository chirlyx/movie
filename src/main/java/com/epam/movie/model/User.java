package com.epam.movie.model;

public class User implements Entity{
    Integer id;
    String firstName;
    String lastName;
    Integer statusId;

    public User(Integer userId, String firstName, String lastname, int statusId) {
        this.id = userId;
        this.firstName = firstName;
        this.lastName = lastname;
        this.statusId = statusId;
    }

    public User(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
}
