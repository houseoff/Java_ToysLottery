package ru.gb.toys_lottery.view.menu.admin;

import ru.gb.toys_lottery.view.command.Back;
import ru.gb.toys_lottery.view.command.admin.EditToyCount;
import ru.gb.toys_lottery.view.command.admin.EditToyName;
import ru.gb.toys_lottery.view.command.admin.EditToyProbability;
import ru.gb.toys_lottery.view.menu.Menu;
import ru.gb.toys_lottery.view.ui.admin.AdminConsoleUI;

public class AdminEditToyMenu extends Menu {

    public AdminEditToyMenu(AdminConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new EditToyName(consoleUI));
        commandList.add(new EditToyCount(consoleUI));
        commandList.add(new EditToyProbability(consoleUI));
        if (consoleUI.previousMenu() != null) {
            commandList.add(new Back(consoleUI));
        }
    }
}
