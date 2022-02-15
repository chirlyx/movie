package com.epam.movie.validation;

public interface Validator {
    boolean isValid(String string, ValidatorRegistry validatorRegistry);
}
