package ru.gb.toys_lottery.view.command;

import ru.gb.toys_lottery.view.ui.ConsoleUI;

public class ShowWinHistory extends Command {
    private final ConsoleUI consoleUI;

    public ShowWinHistory(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        description = "Посмотреть историю выигрышей";
    }

    @Override
    public void execute() {
        consoleUI.getWinHistory();
    }
}
