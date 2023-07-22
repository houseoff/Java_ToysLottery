package ru.gb.toys_lottery.model.lottery;

import java.util.Iterator;
import java.util.List;

public class LotteryToyIterator implements Iterator<LotteryToy> {
    int index;
    List<LotteryToy> toys;

    public LotteryToyIterator(List<LotteryToy> toys) {
        this.toys = toys;
    }

    @Override
    public boolean hasNext() {
        return toys.size() > index;
    }

    @Override
    public LotteryToy next() {
        return toys.get(index++);
    }
}
