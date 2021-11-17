package com.epam.movie.model;

public class Movie implements Entity{
    Integer id;
    String title;
    Integer year;
    Integer categoryId;

    public Movie(Integer id, String title, Integer year, Integer categoryId) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.categoryId = categoryId;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", categoryId=" + categoryId +
                '}';
    }
}
