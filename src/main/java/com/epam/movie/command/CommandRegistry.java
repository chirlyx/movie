package com.epam.movie.command;

import com.epam.movie.model.Role;

import java.util.Arrays;
import java.util.List;

public enum CommandRegistry {
    MAIN_PAGE("main_page", Role.ADMIN, Role.USER),
    LOGIN("login", Role.ADMIN, Role.USER, Role.UNAUTHORIZED),
    LOGOUT("logout", Role.ADMIN, Role.USER, Role.UNAUTHORIZED),
    BANNED("banned", Role.USER),
    SHOW_LOGIN_PAGE("show_login_page", Role.ADMIN, Role.USER, Role.UNAUTHORIZED),
    SHOW_MOVIES("show_movies", Role.ADMIN, Role.USER),
    SHOW_DELETED_MOVIES("show_deleted_movies", Role.ADMIN),
    SHOW_USERS("show_users", Role.ADMIN),
    EDIT_MOVIE("edit_movie", Role.ADMIN),
    SIGN_UP("sign_up", Role.ADMIN, Role.USER, Role.UNAUTHORIZED),
    SIGN_UP_PAGE("sign_up_page", Role.ADMIN, Role.USER, Role.UNAUTHORIZED),
    SINGLE_MOVIE_PAGE("single_movie_page", Role.ADMIN, Role.USER),
    PROFILE("profile", Role.USER),
    SUBMIT_REVIEW("submit_review", Role.ADMIN, Role.USER),
    DELETE_REVIEW("delete_review", Role.ADMIN, Role.USER),
    DELETE_REVIEW_FROM_PROFILE("delete_review_from_profile", Role.USER),
    CREATE_MOVIE("create_movie", Role.ADMIN),
    DELETE_MOVIE("delete_movie", Role.ADMIN),
    UPDATE_MOVIE("update_movie", Role.ADMIN),
    RESTORE_MOVIE("restore_movie", Role.ADMIN),
    UPDATE_STATUS("update_status", Role.ADMIN);

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

