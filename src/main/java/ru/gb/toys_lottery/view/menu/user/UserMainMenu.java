package ru.gb.toys_lottery.view.menu.user;

import ru.gb.toys_lottery.view.command.Finish;
import ru.gb.toys_lottery.view.command.ShowWinHistory;
import ru.gb.toys_lottery.view.command.user.CollectWinnings;
import ru.gb.toys_lottery.view.command.user.PlayLottery;
import ru.gb.toys_lottery.view.command.ShowPrizes;
import ru.gb.toys_lottery.view.command.ShowWinnings;
import ru.gb.toys_lottery.view.menu.Menu;
import ru.gb.toys_lottery.view.ui.user.UserConsoleUI;

public class UserMainMenu extends Menu {

    public UserMainMenu(UserConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new PlayLottery(consoleUI));
        commandList.add(new ShowPrizes(consoleUI));
        commandList.add(new ShowWinnings(consoleUI));
        commandList.add(new CollectWinnings(consoleUI));
        commandList.add(new ShowWinHistory(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}
