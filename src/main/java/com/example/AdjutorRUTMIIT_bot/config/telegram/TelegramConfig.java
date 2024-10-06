package com.example.AdjutorRUTMIIT_bot.config.telegram;

import com.example.AdjutorRUTMIIT_bot.bot.AdjutorRutmiitBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

// Сюда пишем только бины логики телеграм API
@Configuration
public class TelegramConfig {

    @Bean
    public TelegramBotsApi telegramBotsApi(AdjutorRutmiitBot adjutorRutmiitBot) throws TelegramApiException {
        var api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(adjutorRutmiitBot);
        return api;
    }
}
