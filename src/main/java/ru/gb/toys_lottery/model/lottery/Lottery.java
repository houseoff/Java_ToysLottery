package ru.gb.toys_lottery.model.lottery;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import ru.gb.toys_lottery.model.exceptions.NoSuchElementException;
import ru.gb.toys_lottery.model.saveload.Readable;
import ru.gb.toys_lottery.model.saveload.Reading;
import ru.gb.toys_lottery.model.saveload.Writable;
import ru.gb.toys_lottery.model.saveload.Writing;

public class Lottery implements Serializable, Readable<Lottery>, Writable {
    int lotteryId;
    HashMap<Integer, LotteryToy> lotteryToys;
    HashMap<Integer, LotteryToy> issuanceToys;
    WinHistory winHistory;
    boolean saveState;

    public Lottery(int lotteryId) {
        this.lotteryId = lotteryId;
        lotteryToys    = new HashMap<>();
        issuanceToys   = new HashMap<>();
        winHistory     = new WinHistory();
        saveState      = false;
    }

    private LotteryToy extractToy(int toyId, HashMap<Integer, LotteryToy> toys) throws NoSuchElementException {
        LotteryToy extractedToy;
        if (inHashMap(toyId, toys) != -1) {
            extractedToy = toys.get(toyId).copy();
            if (extractedToy.count() == 1) {
                toys.remove(toyId);
            } else {
                toys.get(toyId).setCount(extractedToy.count() - 1);
                extractedToy.setCount(1);
            }
            setSaveState(true);
            return extractedToy;
        } else {
            throw new NoSuchElementException(toyId);
        }
    }

    private LotteryToy getToy(int toyId, HashMap<Integer, LotteryToy> toys) throws NoSuchElementException {
        if (inHashMap(toyId, toys) != -1) return toys.get(toyId);
        else throw new NoSuchElementException(toyId);
    }

    private String getToysToString(HashMap<Integer, LotteryToy> toys) {
        StringBuilder sb = new StringBuilder();
        for (var toy: toys.values()) {
            sb.append(toy.toString()).append("\n");
        }
        return sb.toString();
    }

    private List<LotteryToy> hashMapToList(HashMap<Integer, LotteryToy> hashMap) {
        return new ArrayList<>(hashMap.values());
    }

    private int inHashMap(int toyId, HashMap<Integer, LotteryToy> toys) {
        for (Integer id : toys.keySet()) {
            if (id == toyId) return toyId;
        }
        return -1;
    }

    private void sortByProbability(List<LotteryToy> toys) {
        toys.sort(new LotteryToyComparatorByProbability());
    }

    public void addLotteryToy(LotteryToy toy, HashMap<Integer, LotteryToy> hashMap) {
        if (inHashMap(toy.id(), hashMap) == -1) hashMap.put(toy.id(), toy);
        else {
            int currentCount = hashMap.get(toy.id).count();
            hashMap.get(toy.id).setCount(currentCount + toy.count());
        }
        setSaveState(true);
    }

    public void addToyToHistory(LotteryToy toy) {
        winHistory.addWinHistory(toy);
        setSaveState(true);
    }

    public void clearWinHistory() {
        winHistory.clearWinHistory();
        setSaveState(true);
    }

    public LotteryToy extractIssuanceToy(int toyId) throws NoSuchElementException {
        return extractToy(toyId, issuanceToys);
    }

    public boolean ifExistLotteryToy(int toyId) {
        return inHashMap(toyId, lotteryToys) != -1;
    }

    public LotteryToy getIssuanceToy(int toyId) throws NoSuchElementException {
        return getToy(toyId, issuanceToys);
    }

    public HashMap<Integer, LotteryToy> getIssuanceToys() {
        return issuanceToys;
    }

    public String getIssuanceToysToString() {
        return getToysToString(issuanceToys);
    }

    public LotteryToy getLotteryToy(int toyId) throws NoSuchElementException {
        return getToy(toyId, lotteryToys);
    }

    public HashMap<Integer, LotteryToy> getLotteryToys() {
        return lotteryToys;
    }

    public String getLotteryToysToString() {
        return getToysToString(lotteryToys);
    }

    public int getResultLottery() {
        Random random = new Random();
        List<LotteryToy> toys = hashMapToList(lotteryToys);
        sortByProbability(toys);
        double randomNumber = random.nextDouble();
        double sum = 0;

        for (LotteryToy toy : toys) {
            sum += toy.probability();
            if (sum >= randomNumber) {
                try {
                    addLotteryToy(extractToy(toy.id(), lotteryToys), issuanceToys);
                    return toy.id();
                } catch (NoSuchElementException e) {
                    return -1;
                }
            }
        }
        return -1;
    }

    public boolean getSaveState() {
        return saveState;
    }

    public List<String> getWinHistory() {
        return winHistory.getWinHistory();
    }

    public String getWinHistoryToString() {
        return winHistory.toString();
    }

    public void setSaveState(Boolean state) {
        saveState = state;
    }

    public void setToyName(int toyId, String newName) throws NoSuchElementException {
        getToy(toyId, lotteryToys).setName(newName);
        setSaveState(true);
    }

    public void setToyCount(int toyId, int newCount) throws NoSuchElementException {
        getToy(toyId, lotteryToys).setCount(newCount);
        setSaveState(true);
    }

    public void setToyProbability(int toyId, Double newProbability) throws NoSuchElementException {
        getToy(toyId, lotteryToys).setProbability(newProbability);
        setSaveState(true);
    }

    @Override
    public Lottery read(Reading<Lottery> handler) throws IOException, ClassNotFoundException {
        return handler.read();
    }

    @Override
    public void write(Serializable obj, Writing handler) throws IOException {
        handler.write(this);
    }
}
