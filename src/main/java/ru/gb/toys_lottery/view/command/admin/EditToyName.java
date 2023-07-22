package ru.gb.toys_lottery.view.command.admin;

import ru.gb.toys_lottery.view.command.Command;
import ru.gb.toys_lottery.view.ui.admin.AdminConsoleUI;

public class EditToyName extends Command {
    private final AdminConsoleUI consoleUI;

    public EditToyName(AdminConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        description = "Редактировать наименование игрушки";
    }

    @Override
    public void execute() {
        consoleUI.editToyName();
    }
}
