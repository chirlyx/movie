package com.epam.movie.command;

import com.epam.movie.model.Role;

import java.util.Arrays;
import java.util.List;

public enum CommandRegistry {
    SHOW_MAIN_PAGE("main_page", Role.ADMIN, Role.USER),
    LOGIN("login", Role.ADMIN, Role.USER),
    SHOW_MOVIES_PAGE("show_movies",Role.USER),
    SIGN_UP("sign_up", Role.ADMIN, Role.USER),
    SHOW_SIGN_UP_PAGE("sign_up_page", Role.ADMIN, Role.USER),
    SHOW_SINGLE_MOVIE_PAGE("single_movie_page",Role.ADMIN, Role.USER);

    private final String path;
    private final List<Role> allowedRoles;

    CommandRegistry(String path, Role... roles) {
        this.path = path;
        this.allowedRoles = roles != null && roles.length > 0 ? Arrays.asList(roles) : Role.valuesAsList();
    }

    public String getPath() {
        return path;
    }

    public List<Role> getAllowedRoles() {
        return allowedRoles;
    }
}
