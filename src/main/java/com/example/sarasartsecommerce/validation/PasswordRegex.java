package com.example.sarasartsecommerce.validation;

import java.util.regex.Pattern;

public class PasswordRegex {
    private final Pattern uppercaseRegex;
    private final Pattern lowercaseRegex;
    private final Pattern numbersRegex;
    private final Pattern symbolsRegex;

    public PasswordRegex() {
        uppercaseRegex = Pattern.compile("[A-Z]");
        lowercaseRegex = Pattern.compile("[a-z]");
        numbersRegex = Pattern.compile("[0-9]");
        symbolsRegex = Pattern.compile("[^A-Za-z0-9]");
    }

    public boolean validate(String password) {
        int matches = 0;
        if (uppercaseRegex.matcher(password).find()) matches++;
        if (lowercaseRegex.matcher(password).find()) matches++;
        if (numbersRegex.matcher(password).find()) matches++;
        if (symbolsRegex.matcher(password).find()) matches++;
        if (password.length() >= 8) matches++;
        return matches == 5;
    }
}
