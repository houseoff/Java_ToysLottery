package ru.gb.toys_lottery.model.service;

import ru.gb.toys_lottery.model.exceptions.NoSuchElementException;
import ru.gb.toys_lottery.model.lottery.Lottery;
import ru.gb.toys_lottery.model.lottery.LotteryToy;
import ru.gb.toys_lottery.model.saveload.Reading;
import ru.gb.toys_lottery.model.saveload.Writing;

import java.io.IOException;
import java.io.InvalidClassException;
import java.util.HashMap;

public class LotteryService {
    IDGenerator idGenerator;
    Lottery lottery;

    public LotteryService() {
        this.idGenerator = new IDGenerator();
        this.lottery = new Lottery(idGenerator.getID());
    }

    private Double toDoubleFromString(String data) {
        if (data.matches(".*%$")) {
            return Double.parseDouble(data.replace("%", "")) / 100;
        }
        return Double.parseDouble(data);
    }

    public String addLotteryToy(HashMap<String, String> data) {
        StringBuilder sb = new StringBuilder();
        try {
            lottery.addLotteryToy(new LotteryToy(
                    idGenerator.getID(),
                    data.get("name"),
                    Integer.parseInt(data.get("count")),
                    toDoubleFromString(data.get("probability"))), lottery.getLotteryToys());
            sb.append("Игрушка успешно добавлена в розыгрыш");
            return sb.toString();
        } catch (Exception e) {
            sb.append("Произошла ошибка при добавлении игрушки в розыгрыш: ");
            sb.append(e.getMessage());
            return sb.toString();
        }
    }

    public String clearLotteryResults() {
        lottery.getIssuanceToys().clear();
        return "Результаты лотереи аннулированы";
    }

    public String clearLotteryToys() {
        lottery.getLotteryToys().clear();
        return "Список разыгрываемого успешно очищен";
    }

    public String clearWinHistory() {
        lottery.clearWinHistory();
        return "История выигрышей успешно очищена";
    }

    public String collectWinnings(int toyId) {
        if (lottery.getIssuanceToys().isEmpty()) {
            return "Вы ещё ничего не выиграли";
        }
        try {
            LotteryToy toy = lottery.extractIssuanceToy(toyId);
            lottery.addToyToHistory(toy);
            return "Вы забрали выигрыш: \"" + toy.name() + "\"";
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

    public String exportToObjectFile(Writing handler) {
        try {
            handler.write(lottery);
            return "Экспорт выполнен успешно";
        } catch (IOException e) {
            return "Произошла ошибка при экспорте в файл: " +
                    "проверьте правильность введенного имени и убедитесь, " +
                    "что файл существует";
        }
    }

    public String getIssuanceToys() {
        if (lottery.getIssuanceToys().isEmpty()) {
            return "Корзина пуста";
        }
        return lottery.getIssuanceToysToString();
    }

    public String getLotteryToys() {
        if (isEmptyLotteryToys()) {
            return "В лотерее не участвует ни одна игрушка";
        }
        return lottery.getLotteryToysToString();
    }

    public String getLotteryToy(int toyId) {
        try {
            LotteryToy toy = lottery.getLotteryToy(toyId);
            return toy.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getIssuanceToy(int toyId) {
        try {
            LotteryToy toy = lottery.getIssuanceToy(toyId);
            return toy.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getResultLottery() {
        StringBuilder sb = new StringBuilder();
        int result = lottery.getResultLottery();
        if (result != -1) {
            try {
                sb.append("Поздравляем! Вы выиграли! Ваш приз: \"");
                sb.append(lottery.getIssuanceToy(result).name());
                sb.append("\"! (ID: ").append(lottery.getIssuanceToy(result).id());
                sb.append("). Выигрыш добавлен в список выдачи");
            } catch (NoSuchElementException e) {
                sb.append(e.getMessage());
            }
        } else {
            sb.append("К сожалению, Вы ничего не выиграли");
        }
        return sb.toString();
    }

    public boolean getSaveState() {
        return lottery.getSaveState();
    }

    public String getWinHistory() {
        if (lottery.getWinHistory().isEmpty()) {
            return "История выигрышей пуста. Необходимо забрать выигрыш из корзины для отображения истории";
        }
        return lottery.getWinHistoryToString();
    }

    public String importFromObjectFile(Reading<Lottery> reader) {
        try {
            this.lottery = lottery.read(reader);
            return "Импорт выполнен успешно";
        } catch (InvalidClassException e) {
            return "Произошла ошибка при попытке импортировать дерево: класс для импорта был модифицирован";
        } catch (ClassNotFoundException e) {
            return "Произошла ошибка при попытке импортировать дерево: не найден класс для импорта";
        } catch (IOException e) {
            return "Произошла ошибка при импорте из файла: " +
                    "проверьте правильность введенного имени и убедитесь, " +
                    "что файл существует\n" + e.getMessage();
        } catch (ClassCastException e) {
            return "Произошла ошибка при попытке импортировать дерево: неверные данные";
        }
    }

    public boolean isExistId(int toyId) {
        return lottery.ifExistLotteryToy(toyId);
    }

    public boolean isEmptyLotteryToys() {
        return lottery.getLotteryToys().isEmpty();
    }

    public boolean isEmptyIssuanceToys() {
        return lottery.getIssuanceToys().isEmpty();
    }

    public String setToyName(int toyId, String newName) {
        try {
            lottery.setToyName(toyId, newName);
            return "Наименование изменено успешно";
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

    public String setToyCount(int toyId, int newCount) {
        try {
            lottery.setToyCount(toyId, newCount);
            return "Количество изменено успешно";
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

    public String setToyProbability(int toyId, String newProbability) {
        try {
            lottery.setToyProbability(toyId, toDoubleFromString(newProbability));
            return "Вероятность выигрыша для игрушки изменена успешно";
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

    public void setSaveState(Boolean state) {
        lottery.setSaveState(state);
    }
}
