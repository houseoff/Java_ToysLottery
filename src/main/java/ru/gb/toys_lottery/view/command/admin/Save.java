package ru.gb.toys_lottery.view.command.admin;

import ru.gb.toys_lottery.view.command.Command;
import ru.gb.toys_lottery.view.ui.admin.AdminConsoleUI;

public class Save extends Command {
    private final AdminConsoleUI consoleUI;

    public Save(AdminConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        description = "Сохранить изменения";
    }

    @Override
    public void execute() {
        consoleUI.save();
    }
}
