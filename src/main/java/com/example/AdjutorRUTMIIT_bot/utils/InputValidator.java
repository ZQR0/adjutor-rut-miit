package com.example.AdjutorRUTMIIT_bot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static boolean checkName(String nameOfGroup) {
        String regex = "^[А-Я]{3}-\\d{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nameOfGroup);
        return matcher.matches();
    }
    public static boolean checkSnils(String snils) {
        String regex = "^\\d{3}-\\d{3}-\\d{3} \\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(snils);
        return matcher.matches();
    }
}
