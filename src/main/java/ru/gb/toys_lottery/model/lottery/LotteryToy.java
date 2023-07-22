package ru.gb.toys_lottery.model.lottery;

import java.io.Serializable;

public class LotteryToy implements Serializable {
    int id;
    String name;
    int count;
    double probability;

    public LotteryToy(int id, String name, int count, double probability) {
        this.id = id;
        this.name = name;
        this.count = Math.max(count, 1);
        this.probability = probability;
    }

    public LotteryToy copy() {
        return new LotteryToy(this.id, this.name, this.count, this.probability);
    }

    public int count() {
        return count;
    }

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public double probability() {
        return probability;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    @Override
    public String toString() {
        return "LotteryToy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", probability=" + probability +
                '}';
    }
}
