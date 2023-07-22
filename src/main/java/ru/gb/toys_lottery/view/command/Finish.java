package ru.gb.toys_lottery.view.command;

import ru.gb.toys_lottery.view.ui.ConsoleUI;

public class Finish extends Command {
    private final ConsoleUI consoleUI;

    public Finish(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Выход из программы";
    }

    @Override
    public void execute() { consoleUI.finish(); }
}
