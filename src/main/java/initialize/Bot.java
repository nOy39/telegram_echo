package initialize;

import action.CheckCommands;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Bot extends TelegramLongPollingBot {


    public void onUpdateReceived(Update update) {
        CheckCommands checkCommands = new CheckCommands();
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {

            String text = update.getMessage().getText();
            String name = update.getMessage().getAuthorSignature();

            if (text.substring(0,1).equals("/")) {
                text = checkCommands.validationCommands(text.substring(1));
            }

            SendMessage message = new SendMessage();

            message.setChatId(update.getMessage().getChatId());
            message.setText(text);
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


    public String getBotUsername() {
        return "alpo_jbot";
    }


    public String getBotToken() {
        return "602985843:AAGRTafBn-Z2oWaokQPU4LzS9oFwvTfL_xU";
    }
}
