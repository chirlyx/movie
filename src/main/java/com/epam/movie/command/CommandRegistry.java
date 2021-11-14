package com.epam.movie.command;

public enum CommandRegistry {
    MAIN_PAGE("main_page"),
    LOGIN("login");

    private final String path;

    CommandRegistry(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
