package com.example.AdjutorRUTMIIT_bot.utils;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class CheckName {
    public static boolean checkName(String nameOfGroup) {
        String regex = "^[А-Я]{3}-\\d{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nameOfGroup);
        return matcher.matches();
    }
}
