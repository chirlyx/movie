package com.epam.movie.model;

import java.util.Arrays;
import java.util.List;

public enum Status {
    BEGINNER(1, "Beginner", 0),
    INTERMEDIATE(2, "Intermediate", 5),
    ADVANCED(3, "Advanced", 10),
    EXPERT(4, "Expert", 15);

    private final Integer statusId;
    private final String name;
    private final Integer bottomValue;

    Status(Integer statusId, String name, Integer bottomValue) {
        this.statusId = statusId;
        this.name = name;
        this.bottomValue = bottomValue;
    }

    private static final List<Status> AlL_STATUSES = Arrays.asList(values());

    public static List<Status> valuesAsList() {
        return AlL_STATUSES;
    }

    public static Status byId(Integer id) {
        for (Status status : values()) {
            if (status.getStatusId().equals(id)) {
                return status;
            }
        }
        return BEGINNER;
    }

    public static Status byNumberOfReviews(Integer reviewNumber) {
        for (int i = AlL_STATUSES.size()-1; i >= 0; i--) {
            if (reviewNumber >= AlL_STATUSES.get(i).getBottomValue()) {
                return AlL_STATUSES.get(i);
            }
        }
        return BEGINNER;
    }

    public String getName() {
        return name;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public Integer getBottomValue() {
        return bottomValue;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", name='" + name + '\'' +
                ", bottomValue=" + bottomValue +
                '}';
    }
}
