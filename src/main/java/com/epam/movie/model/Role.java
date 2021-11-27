package com.epam.movie.model;

import java.util.Arrays;
import java.util.List;

public enum Role {
    ADMIN,
    USER;

    private static final List<Role> ALL_AVAILABLE_ROLES = Arrays.asList(values());

    public static List<Role> valuesAsList() {
        return ALL_AVAILABLE_ROLES;
    }

    public static Role of(String name) {
        for (Role role : values()) {
            if (role.name().equalsIgnoreCase(name)) {
                return role;
            }
        }
        return USER;
    }
}
