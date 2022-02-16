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

    @Override
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

    public void setBanStatus(BanStatus banStatus) {
        this.banStatus = banStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && status == user.status && banStatus == user.banStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, status, banStatus);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", banStatus=" + banStatus +
                '}';
    }
}
