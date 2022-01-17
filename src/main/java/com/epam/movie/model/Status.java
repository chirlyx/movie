package com.epam.movie.model;

import java.util.Arrays;
import java.util.List;

public enum Status {
    BEGINNER(1, "Beginner"),
    INTERMEDIATE(2, "Intermediate"),
    ADVANCED(3, "3"),
    EXPERT(4, "4"),
    BANNED(6, "BANNED");

    private final Integer statusId;
    private final String name;

    Status(Integer statusId, String name) {
        this.statusId = statusId;
        this.name = name;
    }

    private static final List<Status> AlL_STATUSES = Arrays.asList(values());

    public static List<Status> valuesAsList() {
        return AlL_STATUSES;
    }

    public static Status byId (Integer id) {
        for (Status status : values()) {
            if (status.getStatusId().equals(id)) {
                return status;
            }
        }
        return BANNED;
    }

    public String getName() {
        return name;
    }

    public Integer getStatusId() {
        return statusId;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", name='" + name + '\'' +
                '}';
    }
}
