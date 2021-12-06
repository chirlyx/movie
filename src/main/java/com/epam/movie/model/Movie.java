package com.epam.movie.model;

import java.util.*;

public class Movie implements Entity {
    private Integer id;
    private String title;
    private Integer year;
    private Category category;
    private List<Actor> actorList;

    public Movie(Integer id, String title, Integer year, Integer categoryId, Actor... actorList) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.category = Category.byId(categoryId);
        this.actorList = actorList != null && actorList.length > 0 ? Arrays.asList(actorList) : new ArrayList<>();
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

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
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