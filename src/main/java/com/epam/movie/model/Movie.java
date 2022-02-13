package com.epam.movie.model;

import java.util.*;

public class Movie implements Entity {
    private Integer id;
    private String title;
    private Integer year;
    private Category category;
    private String description;
    private Boolean deleted;

    public Movie(Integer id, String title, Integer year, Integer categoryId, String description, Boolean deleted) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.category = Category.byId(categoryId);
        this.description = description;
        this.deleted = deleted;
    }

    public Movie(String title, Integer year, Integer categoryId, String description) {
        this.title = title;
        this.year = year;
        this.category = Category.byId(categoryId);
        this.description = description;
        this.deleted = deleted;
    }

    public Movie() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(title, movie.title) && Objects.equals(year, movie.year) && category == movie.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, category);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", category=" + category +
                '}';
    }
}