package ru.gb.toys_lottery.presenter.user;

import ru.gb.toys_lottery.model.lottery.Lottery;
import ru.gb.toys_lottery.model.saveload.LoadFileHandler;
import ru.gb.toys_lottery.model.saveload.Reading;
import ru.gb.toys_lottery.model.saveload.SaveFileHandler;
import ru.gb.toys_lottery.model.saveload.Writing;
import ru.gb.toys_lottery.presenter.Presenter;
import ru.gb.toys_lottery.view.View;

public class UserPresenter extends Presenter {

    public UserPresenter(View view) {
        super(view);
    }

    public void autoImportFromObjectFile() {
        Reading<Lottery> handler = new LoadFileHandler<>("lottery.db");
        lotteryService.importFromObjectFile(handler);
    }

    public void autoExportToObjectFile() {
        Writing handler = new SaveFileHandler("lottery.db");
        lotteryService.exportToObjectFile(handler);
    }

    public void getWinHistory() {
        view().print(lotteryService.getWinHistory());
    }

    public boolean isEmptyWinnings() {
        return lotteryService.isEmptyIssuanceToys();
    }

    public void playLottery() {
        view().print(lotteryService.getResultLottery());
    }

    public void showPrizes() {
        view().print(lotteryService.getLotteryToys());
    }

    public void showWinnings() {
        view().print(lotteryService.getIssuanceToys());
    }

    public void collectWinnings(int toyId) {
        view().print(lotteryService.collectWinnings(toyId));
    }
}
