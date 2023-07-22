package ru.gb.toys_lottery.view.command;

import ru.gb.toys_lottery.view.ui.ConsoleUI;

public class ShowWinnings extends Command {
    private final ConsoleUI consoleUI;

    public ShowWinnings(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Посмотреть корзину выигрышей";
    }

    @Override
    public void execute() {
        consoleUI.showWinnings();
    }
}
