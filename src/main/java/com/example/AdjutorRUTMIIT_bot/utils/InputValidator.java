package com.example.AdjutorRUTMIIT_bot.utils;

public class InputValidator {
    public static boolean check(String name_group) {
        String[] badWords = {"fuck", "cock", "dick"};
        for (String word : badWords) {
            if (name_group == word) {
                return false;
            }
        }
        return true;
    }
}
