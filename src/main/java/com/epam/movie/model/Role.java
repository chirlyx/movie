package com.epam.movie.model;

import java.util.Arrays;
import java.util.List;

public enum Role {
    ADMIN(1),
    USER(2),
    UNAUTHORIZED(3);

    private final Integer roleId;

    Role(Integer roleId) {
        this.roleId = roleId;
    }

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

    public static Role byId (Integer id) {
        for (Role role : values()) {
            if (role.getRoleId().equals(id)) {
                return role;
            }
        }
        return USER;
    }

    public Integer getRoleId() {
        return roleId;
    }
}
