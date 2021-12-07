package com.epam.movie.model;

import java.util.Objects;

public class User implements Entity{
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer statusId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && firstName.equals(user.firstName) && lastName.equals(user.lastName) && statusId.equals(user.statusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, statusId);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", statusId=" + statusId +
                '}';
    }
}
