package ru.gb.toys_lottery.view.command.admin;

import ru.gb.toys_lottery.view.command.Command;
import ru.gb.toys_lottery.view.ui.admin.AdminConsoleUI;

public class Import extends Command {
    private final AdminConsoleUI consoleUI;

    public Import(AdminConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        description = "Импортировать лотерею из файла";
    }

    @Override
    public void execute() {
        consoleUI.importFromObjectFile();
    }
}
