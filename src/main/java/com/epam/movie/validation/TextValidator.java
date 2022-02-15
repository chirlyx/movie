package com.epam.movie.validation;

public class TextValidator implements Validator {
    private final String string;
    private final ValidatorRegistry validatorType;

    public TextValidator(String string, ValidatorRegistry validatorType) {
        this.string = string;
        this.validatorType = validatorType;
    }

    @Override
    public boolean isValid(String string, ValidatorRegistry validatorType) {
        if (!(string == null || string.equals("") || string.trim().equals(""))) {
            String regex = validatorType.getRegex();
            if (string.matches(regex)) {
                return true;
            }
        }
        return false;
    }
}
