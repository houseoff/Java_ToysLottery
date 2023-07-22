package ru.gb.toys_lottery.view.command.admin;

import ru.gb.toys_lottery.view.command.Command;
import ru.gb.toys_lottery.view.ui.admin.AdminConsoleUI;

public class EditToyProbability extends Command {
    private final AdminConsoleUI consoleUI;

    public EditToyProbability(AdminConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        description = "Редактировать вероятность выпадения игрушки";
    }

    @Override
    public void execute() {
        consoleUI.editToyProbability();
    }
}
