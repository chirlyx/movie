package com.epam.movie.validation;

public enum ValidatorRegistry {
    LOGIN("^[a-zA-Z0-9]{4,25}$"),
    PASSWORD("^[a-zA-Z0-9]{8,50}$"),
    NAME("^[a-zA-Z]{2,35}$"),
    TITLE("^[a-zA-Z0-9 .,]{4,35}$"),
    YEAR("^[0-9]{4,4}$"),
    DESCRIPTION("^[a-zA-Z0-9 .,]{4,500000}$"),
    COMMENT("^[a-zA-Z0-9 .,]{4,500000}$"),
    ID("^[0-9]$"),
    DEFAULT("^[a-zA-Z0-9 .,]");

    private final String regex;

    ValidatorRegistry(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
