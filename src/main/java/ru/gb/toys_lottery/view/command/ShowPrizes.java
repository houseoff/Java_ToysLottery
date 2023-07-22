package ru.gb.toys_lottery.view.command;

import ru.gb.toys_lottery.view.ui.ConsoleUI;

public class ShowPrizes extends Command {
    private final ConsoleUI consoleUI;

    public ShowPrizes(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Показать список призов";
    }

    @Override
    public void execute() {
        consoleUI.showPrizes();
    }
}
