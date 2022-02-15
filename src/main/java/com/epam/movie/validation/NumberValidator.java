package com.epam.movie.validation;

public class NumberValidator implements Validator{
    private final String string;
    private final ValidatorRegistry validatorType;

    public NumberValidator(String string, ValidatorRegistry validatorType) {
        this.string = string;
        this.validatorType = validatorType;
    }

    @Override
    public boolean isValid(String string, ValidatorRegistry validatorType) {
        if (!(string == null || string.equals("") || string.trim().equals(""))) {
            if(isNumeric(string)) {
                String regex = validatorType.getRegex();
                if (string.matches(regex)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
}
