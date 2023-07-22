package ru.gb.toys_lottery.view.command.admin;

import ru.gb.toys_lottery.view.command.Command;
import ru.gb.toys_lottery.view.ui.admin.AdminConsoleUI;

public class ClearWinHistory extends Command {
    private final AdminConsoleUI consoleUI;

    public ClearWinHistory(AdminConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        description = "Очистить историю выигрышей";
    }

    @Override
    public void execute() {
        consoleUI.clearWinHistory();
    }
}
