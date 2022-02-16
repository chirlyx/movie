package com.epam.movie.model;

import java.util.Arrays;
import java.util.List;

public enum Category {
    ACTION(1, "Action"),
    COMEDY(2, "Comedy"),
    DETECTIVE(3, "Detective"),
    FANTASY(4, "Fantasy"),
    HORROR(5, "Horror"),
    MYSTERY(6, "Mystery"),
    ROMANCE(7, "Romance"),
    THRILLER(8, "Thriller");

    private final Integer categoryId;
    private final String name;

    Category(Integer categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    private static final List<Category> ALL_CATEGORIES = Arrays.asList(values());

    public static List<Category> valuesAsList() {
        return ALL_CATEGORIES;
    }

    public static Category byId (Integer id) {
        for (Category category : values()) {
            if (category.getCategoryId().equals(id)) {
                return category;
            }
        }
        return COMEDY;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }
}
