package com.example.AdjutorRUTMIIT_bot.utils;

import com.example.AdjutorRUTMIIT_bot.exception.InvalidSNILSFormatException;
import lombok.NonNull;

public class SnilsParser {

    public static String convertSNILSToString(@NonNull String SNILS)
        throws InvalidSNILSFormatException
    {
        if (!InputValidator.checkSnils(SNILS)) {
            throw new InvalidSNILSFormatException(String.format("SNILS: %s has invalid format", SNILS));
        }

        StringBuilder stringBuilder = new StringBuilder(SNILS);

        stringBuilder.deleteCharAt(3);
        stringBuilder.deleteCharAt(6);
        stringBuilder.deleteCharAt(9);

        return stringBuilder.toString();
    }

    // 123456789 12
    public static String convertStringToSNILS(@NonNull String string) {
        string = string.strip();

        String firstPart = string.substring(0, 3);
        String secondPart = string.substring(3, 6);
        String thirdPart = string.substring(6, 9);
        String fourthPart = string.substring(9, 11);

        return String.format("%s-%s-%s %s", firstPart, secondPart, thirdPart, fourthPart);
    }

}
