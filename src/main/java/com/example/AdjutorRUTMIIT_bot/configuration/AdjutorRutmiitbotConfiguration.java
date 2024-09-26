package com.example.AdjutorRUTMIIT_bot.configuration;

import com.example.AdjutorRUTMIIT_bot.bot.AdjutorRutmiitBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class AdjutorRutmiitbotConfiguration {

    @Bean
    public TelegramBotsApi telegramBotsApi (AdjutorRutmiitBot adjutorRutmiitBot) throws TelegramApiException {
        var api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(adjutorRutmiitBot);
        return api;
    }
}
