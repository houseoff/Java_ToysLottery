package ru.gb.toys_lottery.presenter.admin;

import ru.gb.toys_lottery.model.lottery.Lottery;
import ru.gb.toys_lottery.model.saveload.LoadFileHandler;
import ru.gb.toys_lottery.model.saveload.Reading;
import ru.gb.toys_lottery.model.saveload.SaveFileHandler;
import ru.gb.toys_lottery.model.saveload.Writing;
import ru.gb.toys_lottery.presenter.Presenter;
import ru.gb.toys_lottery.view.View;

import java.util.HashMap;

public class AdminPresenter extends Presenter {

    public AdminPresenter(View view) {
        super(view);
    }

    public void addToy(HashMap<String, String> data) {
        view().print(lotteryService.addLotteryToy(data));
    }

    public void clearLotteryResults() {
        view().print(lotteryService.clearLotteryResults());
    }

    public void clearLotteryToys() {
        view().print(lotteryService.clearLotteryToys());
    }

    public void clearWinHistory() {
        view().print(lotteryService.clearWinHistory());
    }

    public void editToyCount(int toyId, int count) {
        view().print(lotteryService.setToyCount(toyId, count));
    }

    public void editToyName(int toyId, String name) {
        view().print(lotteryService.setToyName(toyId, name));
    }

    public void editToyProbability(int toyId, String probability) {
        view().print(lotteryService.setToyProbability(toyId, probability));
    }

    public void exportToObjectFile(String fileName) {
        Writing handler = new SaveFileHandler(fileName);
        view().print(lotteryService.exportToObjectFile(handler));
    }

    public boolean getSaveState() {
        return lotteryService.getSaveState();
    }

    public void getWinHistory() {
        view().print(lotteryService.getWinHistory());
    }

    public void importFromObjectFile(String fileName) {
        Reading<Lottery> handler = new LoadFileHandler<>(fileName);
        view().print(lotteryService.importFromObjectFile(handler));
    }

    public boolean isEmptyLotteryToys() {
        return lotteryService.isEmptyLotteryToys();
    }

    public boolean isExistId(int toyId) {
        return lotteryService.isExistId(toyId);
    }

    public void showPrizes() {
        view().print(lotteryService.getLotteryToys());
    }

    public void showWinnings() {
        view().print(lotteryService.getIssuanceToys());
    }

    public void setSaveState(Boolean state) {
        lotteryService.setSaveState(state);
    }
}
