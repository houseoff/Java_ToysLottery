package ru.gb.toys_lottery.view.command.admin;

import ru.gb.toys_lottery.view.command.Command;
import ru.gb.toys_lottery.view.ui.admin.AdminConsoleUI;

public class Export extends Command {
    private final AdminConsoleUI consoleUI;

    public Export(AdminConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        description = "Экспортировать лотерею в файл";
    }

    @Override
    public void execute() {
        consoleUI.exportToObjectFile();
    }
}
