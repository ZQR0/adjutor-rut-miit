package com.example.AdjutorRUTMIIT_bot.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
@SpringBootTest
public class InputValidatorTests {

    private static final String nameOfGroup = "УВП-111";
    private static final String snils = "123-456-789 12";
    private static final String nameOfGroupFalse = "фаврфы-123";
    private static final String snilsFalse = "1231231237234";
    private static final String banWord = "сучка";
    private static final String nobanWord = "собака";

    @Test
    void checkNameToRegexTest() {
        assertThat(InputValidator.checkName(nameOfGroup)).isTrue();
    }
    @Test
    void checkSnilsToRegexTest(){
        assertThat(InputValidator.checkSnils(snils)).isTrue();
    }
    @Test
    void checkNameFalseToRegexTest(){
        assertThat(InputValidator.checkSnils(nameOfGroupFalse)).isFalse();
    }
    @Test
    void checkSnilsFalseToRegexTest(){
        assertThat(InputValidator.checkSnils(snilsFalse)).isFalse();
    }
    @Test
    void checkBadWordsTest(){
        assertThat(InputValidator.check(banWord)).isFalse();
    }
    @Test
    void checkNoBadWordsTest(){
        assertThat(InputValidator.check(nobanWord)).isTrue();
    }
}
