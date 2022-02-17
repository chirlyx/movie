package com.epam.movie.validation;

public class ValidatorFactory {

    public Validator create(ValidatorRegistry type, String string) {

        switch (type) {
            case LOGIN:
                return new TextValidator(string, ValidatorRegistry.LOGIN);
            case PASSWORD:
                return new TextValidator(string, ValidatorRegistry.PASSWORD);
            case NAME:
                return new TextValidator(string, ValidatorRegistry.NAME);
            case TITLE:
                return new TextValidator(string, ValidatorRegistry.TITLE);
            case YEAR:
                return new NumberValidator(string, ValidatorRegistry.LOGIN);
            case DESCRIPTION:
                return new TextValidator(string, ValidatorRegistry.DESCRIPTION);
            case COMMENT:
                return new TextValidator(string, ValidatorRegistry.COMMENT);
            default:
                return new TextValidator(string, ValidatorRegistry.DEFAULT);
        }
    }
}
