package com.epam.movie.model;

import java.util.Objects;

public class Review implements Entity {
    private Integer id;
    private Integer userId;
    private Integer movieId;
    private Integer mark;
    private String comment;

    public Review(Integer id, Integer userId, Integer movieId, Integer mark, String comment) {
        this.id = id;
        this.userId = userId;
        this.movieId = movieId;
        this.mark = mark;
        this.comment = comment;
    }

    public Review(Integer userId, Integer movieId, Integer mark, String comment) {
        this.userId = userId;
        this.movieId = movieId;
        this.mark = mark;
        this.comment = comment;
    }

    public Review() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id) && Objects.equals(userId, review.userId) && Objects.equals(movieId, review.movieId) && Objects.equals(mark, review.mark) && Objects.equals(comment, review.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, movieId, mark, comment);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", userId=" + userId +
                ", movieId=" + movieId +
                ", mark=" + mark +
                ", comment='" + comment + '\'' +
                '}';
    }
}
