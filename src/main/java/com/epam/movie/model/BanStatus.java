package com.epam.movie.model;

import java.util.Arrays;
import java.util.List;

public enum BanStatus {
    ACTIVE(1, "Active"),
    BANNED(2, "Banned");

    private final Integer banStatusId;
    private final String name;

    BanStatus(Integer banStatusId, String name) {
        this.banStatusId = banStatusId;
        this.name = name;
    }

    private static final List<BanStatus> ALL_CATEGORIES = Arrays.asList(values());

    public static List<BanStatus> valuesAsList() {
        return ALL_CATEGORIES;
    }

    public static BanStatus byId (Integer id) {
        for (BanStatus banStatus : values()) {
            if (banStatus.getBanStatusId().equals(id)) {
                return banStatus;
            }
        }
        return BANNED;
    }

    public Integer getBanStatusId() {
        return banStatusId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BanStatus{" +
                "banStatusId=" + banStatusId +
                ", name='" + name + '\'' +
                '}';
    }
}
