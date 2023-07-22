package ru.gb.toys_lottery.view.command.admin;

import ru.gb.toys_lottery.view.command.Command;
import ru.gb.toys_lottery.view.ui.admin.AdminConsoleUI;

public class EditToy extends Command {
    private final AdminConsoleUI consoleUI;

    public EditToy(AdminConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        description = "Изменить данные разыгрываемой игрушки по ID";
    }

    @Override
    public void execute() {
        consoleUI.editToy();
    }
}
