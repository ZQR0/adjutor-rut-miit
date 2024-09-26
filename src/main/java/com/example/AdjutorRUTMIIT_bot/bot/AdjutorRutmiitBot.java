package com.example.AdjutorRUTMIIT_bot.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update ;

@Component
public class AdjutorRutmiitBot extends TelegramLongPollingBot{

    public AdjutorRutmiitBot (String botToken) {
        super (botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return "AdjutorRUTMIIT_bot";
    }
}
