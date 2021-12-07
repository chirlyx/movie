package com.epam.movie.model;

import java.util.Objects;

public class Account implements Entity {
    private Integer id;
    private String login;
    private String password;
    private Role role;

    public Account(Integer id, String login, String password, Integer roleId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = Role.byId(roleId);
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
        this.role = Role.USER;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(login, account.login) && Objects.equals(password, account.password) && role == account.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, role);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
