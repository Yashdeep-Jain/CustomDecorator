package com.example.business;

public class StringProcessor {
    public String reverseString(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return new StringBuilder(input).reverse().toString();
    }

    public String toUpperCase(String input) {
        return input.toUpperCase();
    }

    public int getStringLength(String input) {
        return input != null ? input.length() : 0;
    }
}
