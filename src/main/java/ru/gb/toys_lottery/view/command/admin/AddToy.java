package ru.gb.toys_lottery.view.command.admin;

import ru.gb.toys_lottery.view.command.Command;
import ru.gb.toys_lottery.view.ui.admin.AdminConsoleUI;

public class AddToy extends Command {
    private final AdminConsoleUI consoleUI;

    public AddToy(AdminConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        description = "Добавление игрушки к розыгрышу";
    }

    @Override
    public void execute() {
        consoleUI.addToy();
    }
}
