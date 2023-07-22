package ru.gb.toys_lottery.view.command.admin;

import ru.gb.toys_lottery.view.command.Command;
import ru.gb.toys_lottery.view.ui.admin.AdminConsoleUI;

public class EditToyCount extends Command {
    private final AdminConsoleUI consoleUI;

    public EditToyCount(AdminConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        description = "Редактировать количество игрушек";
    }

    @Override
    public void execute() {
        consoleUI.editToyCount();
    }
}
