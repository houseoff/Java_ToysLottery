package ru.gb.toys_lottery.model.exceptions;

public class NoSuchElementException extends Exception {
    public NoSuchElementException(String message) {
        super(message);
    }

    public NoSuchElementException(int toyId) {
        super("Игрушки с ID " + toyId + " не найдено");
    }
}
