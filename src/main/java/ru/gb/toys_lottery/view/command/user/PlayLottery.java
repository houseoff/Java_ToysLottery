package ru.gb.toys_lottery.view.command.user;

import ru.gb.toys_lottery.view.command.Command;
import ru.gb.toys_lottery.view.ui.user.UserConsoleUI;

public class PlayLottery extends Command {
    private final UserConsoleUI consoleUI;

    public PlayLottery(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        description = "Сыграть в лотерею";
    }

    @Override
    public void execute() {
        consoleUI.playLottery();
    }
}
