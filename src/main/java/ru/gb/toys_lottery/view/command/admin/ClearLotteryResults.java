package ru.gb.toys_lottery.view.command.admin;

import ru.gb.toys_lottery.view.command.Command;
import ru.gb.toys_lottery.view.ui.admin.AdminConsoleUI;

public class ClearLotteryResults extends Command {
    private final AdminConsoleUI consoleUI;

    public ClearLotteryResults(AdminConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        description = "Аннулировать результаты лотереи";
    }

    @Override
    public void execute() {
        consoleUI.clearLotteryResults();
    }
}
