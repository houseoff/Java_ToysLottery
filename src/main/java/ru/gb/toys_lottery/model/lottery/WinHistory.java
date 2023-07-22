package ru.gb.toys_lottery.model.lottery;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WinHistory implements Serializable {
    private final List<String> winHistory;

    public WinHistory() {
        winHistory = new ArrayList<>();
    }

    private String getDateNow() {
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return datetime.format(formatter);
    }

    public void addWinHistory(LotteryToy toy) {
        String toyInfo = "ID: " + toy.id() + ", " +
                "Наименование: \"" + toy.name() + "\", " +
                "Дата и время выигрыша: " + getDateNow();
        winHistory.add(toyInfo);
    }

    public void clearWinHistory() {
        winHistory.clear();
    }

    public List<String> getWinHistory() {
        return winHistory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String historyRecord : winHistory) {
            sb.append(historyRecord).append("\n");
        }
        return sb.toString();
    }
}
