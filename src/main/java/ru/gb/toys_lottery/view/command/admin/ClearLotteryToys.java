package ru.gb.toys_lottery.view.command.admin;

import ru.gb.toys_lottery.view.command.Command;
import ru.gb.toys_lottery.view.ui.admin.AdminConsoleUI;

public class ClearLotteryToys extends Command {
    private final AdminConsoleUI consoleUI;

    public ClearLotteryToys(AdminConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        description = "Очистить список разыгрываемого";
    }

    @Override
    public void execute() {
        consoleUI.clearLotteryToys();
    }
}
