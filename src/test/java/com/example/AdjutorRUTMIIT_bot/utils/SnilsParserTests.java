package com.example.AdjutorRUTMIIT_bot.utils;

import com.example.AdjutorRUTMIIT_bot.exception.InvalidSNILSFormatException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class SnilsParserTests {

    private static final String SNILS = "123-456-789 12";
    private static final String STRING = "12345678912";

    @Test
    void convertSNILSToStringTest() throws InvalidSNILSFormatException {
        assertThat(SnilsParser.convertSNILSToString(SNILS)).isEqualTo(STRING);
    }

    @Test
    void convertStringToSNILS() {
        assertThat(SnilsParser.convertStringToSNILS(STRING)).isEqualTo(SNILS);
    }

}
