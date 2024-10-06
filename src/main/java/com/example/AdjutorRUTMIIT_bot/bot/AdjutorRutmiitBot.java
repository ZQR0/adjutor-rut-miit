package com.example.AdjutorRUTMIIT_bot.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update ;

/**
 * В этом файле написана конфигурация телеграм бота
 * Токен и имя пользователя
 * Данные подтягиваются из application.yml
 * @author Yaroslav
 * */
@Component
@Slf4j
public class AdjutorRutmiitBot extends TelegramLongPollingBot {

    @Value(value = "${bot.token}")
    private String token;

    @Value(value = "{$bot.name}")
    private String botName;


    @Override
    public void onUpdateReceived(Update update) {
        log.info("Bot works");
    }

    @Override
    public String getBotUsername() {
        return this.botName;
    }

    @Override
    public String getBotToken() {
        return this.token;
    }

//    @Override
//    public void onRegister() {
//        log.info("Registered");
//    }
}
