package com.epam.movie.model;

public enum Category {
    COMEDY(1),
    DRAMA(2);

    private final Integer categoryId;

    Category(Integer categoryId) {
        this.categoryId = categoryId;
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
}
