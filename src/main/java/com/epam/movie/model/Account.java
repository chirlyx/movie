package com.epam.movie.model;

public class Account implements Entity{
    Integer id;
    String login;
    String password;
    int roleId;

    public Account(Integer id, String login, String password, int role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roleId = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
