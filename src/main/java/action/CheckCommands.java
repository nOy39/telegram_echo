package action;


import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckCommands {

    public static boolean isRunning;

    public String validationCommands(String text) {
        String answer = new String();

        if (text.equals("date")) {
            answer = getDate();
        }

        if (text.equals("name")) {

        }


        if (text.equals("time")) {
            answer = getTime();
        }

        if(text.equals("list")) {
            answer = getComand();
        }


        return answer;

    }

    private String getComand() {
        String command = "Список доступных команд:\n/date - сегодняшняя дата,\n" +
                "/time - текущее время.";
        return command;
    }

    private String getTime() {
        SimpleDateFormat sfr = new SimpleDateFormat("HH:mm:ss");
        return sfr.format(new Date());
    }

    private String getDate() {
        SimpleDateFormat sfr = new SimpleDateFormat("EEE dd MMM yyyy");
        return sfr.format(new Date());
    }

}
