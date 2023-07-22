package ru.gb.toys_lottery.view.menu.admin;

import ru.gb.toys_lottery.view.command.Finish;
import ru.gb.toys_lottery.view.command.admin.AddToy;
import ru.gb.toys_lottery.view.command.admin.Import;
import ru.gb.toys_lottery.view.menu.Menu;
import ru.gb.toys_lottery.view.ui.admin.AdminConsoleUI;

public class AdminEmptyLotteryMainMenu extends Menu {

    public AdminEmptyLotteryMainMenu(AdminConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new Import(consoleUI));
        commandList.add(new AddToy(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}
