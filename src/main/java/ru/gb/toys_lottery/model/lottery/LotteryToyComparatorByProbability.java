package ru.gb.toys_lottery.model.lottery;

import java.util.Comparator;

public class LotteryToyComparatorByProbability implements Comparator<LotteryToy> {

    @Override
    public int compare(LotteryToy o1, LotteryToy o2) {
        return Double.compare(o2.probability, o1.probability);
    }
}
