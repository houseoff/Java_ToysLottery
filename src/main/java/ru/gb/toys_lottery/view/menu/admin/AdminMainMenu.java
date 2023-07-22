package ru.gb.toys_lottery.view.menu.admin;

import ru.gb.toys_lottery.view.command.Finish;
import ru.gb.toys_lottery.view.command.ShowPrizes;
import ru.gb.toys_lottery.view.command.ShowWinHistory;
import ru.gb.toys_lottery.view.command.ShowWinnings;
import ru.gb.toys_lottery.view.command.admin.*;
import ru.gb.toys_lottery.view.menu.Menu;
import ru.gb.toys_lottery.view.ui.admin.AdminConsoleUI;

public class AdminMainMenu extends Menu {

    public AdminMainMenu(AdminConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new ShowPrizes(consoleUI));
        commandList.add(new ShowWinnings(consoleUI));
        commandList.add(new ShowWinHistory(consoleUI));
        commandList.add(new AddToy(consoleUI));
        commandList.add(new EditToy(consoleUI));
        commandList.add(new ClearLotteryToys(consoleUI));
        commandList.add(new ClearLotteryResults(consoleUI));
        commandList.add(new ClearWinHistory(consoleUI));
        if (consoleUI.getSaveState()) {
            commandList.add(new Save(consoleUI));
        }
        commandList.add(new Export(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}
