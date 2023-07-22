package ru.gb.toys_lottery.presenter;

import ru.gb.toys_lottery.model.service.LotteryService;
import ru.gb.toys_lottery.view.View;

public abstract class Presenter {
    protected View view;
    protected LotteryService lotteryService;

    public Presenter(View view) {
        this.view = view;
        this.lotteryService = new LotteryService();
    }

    public View view() {
        return view;
    }
}
