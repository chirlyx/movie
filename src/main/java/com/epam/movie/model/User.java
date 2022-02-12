package com.epam.movie.model;

import java.util.Objects;

public class User implements Entity{
    private Integer id;
    private String firstName;
    private String lastName;
    private Status status;
    private BanStatus banStatus;

    public User(Integer userId, String firstName, String lastname, int statusId, int banStatusId) {
        this.id = userId;
        this.firstName = firstName;
        this.lastName = lastname;
        this.status = Status.byId(statusId);
        this.banStatus = BanStatus.byId(banStatusId);
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BanStatus getBanStatus() {
        return banStatus;
    }
}
