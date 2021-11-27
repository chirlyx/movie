package com.epam.movie.model;

import java.util.Objects;

public class Account implements Entity {
    Integer id;
    String login;
    String password;
    Integer roleId;

    public Account(Integer id, String login, String password, Integer role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roleId = role;
    }

    public Account(String login, String password, int roleId) {
        this.login = login;
        this.password = password;
        this.roleId = 2;
    }

    public Account() {
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id.equals(account.id) && login.equals(account.login) && password.equals(account.password) && roleId.equals(account.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, roleId);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                '}';
    }


}
