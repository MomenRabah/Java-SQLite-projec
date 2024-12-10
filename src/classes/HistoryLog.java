package classes;

import services.HistoryLogService;

import java.util.Date;
import java.util.*;

public class HistoryLog{
    private static final HistoryLogService historyLogService = new HistoryLogService();


    public enum Action{
        CREATED, UPDATED, DELETED;
    }

    public enum AuthAction{
        LOGGEDIN, REGISTERED, LOGGEDOUT
    }
    public static void history(User user, String entity, int id,Action action){
        Date date = new Date();
        String x= (user.getUsername()  + " has "+action.name()+" " + entity + " with id (" + id + ")" + " at "+ date);
        historyLogService.createHistoryLog(x,user.getUserid());
    }

    public static void historyAuth(User user,AuthAction action){
        Date date = new Date();
        String x= (user.getUsername()  + " has "+action.name()+" at "+ date);
        historyLogService.createHistoryLog(x,user.getUserid());
    }

    public static void printAllHistoryLogs() {
        List<String> logs = historyLogService.getAllHistoryLogs();
        if (logs.isEmpty()) {
            System.out.println("No history logs found.");
        } else {
            for (String log : logs) {
                System.out.println(log);
            }
        }
    }

    public static void printAllUserHistoryLogs(int userId) {
        List<String> logs = historyLogService.getUserHistory(userId);
        if (logs.isEmpty()) {
            System.out.println("No history logs found.");
        } else {
            for (String log : logs) {
                System.out.println(log);
            }
        }
    }
}