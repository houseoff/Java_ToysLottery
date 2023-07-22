package ru.gb.toys_lottery.view.command.user;

import ru.gb.toys_lottery.view.command.Command;
import ru.gb.toys_lottery.view.ui.user.UserConsoleUI;

public class CollectWinnings extends Command {
    private final UserConsoleUI consoleUI;

    public CollectWinnings(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Забрать выигрыш из корзины";
    }

    @Override
    public void execute() {
        consoleUI.collectWinnings();
    }
}
