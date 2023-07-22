package ru.gb.toys_lottery;

import ru.gb.toys_lottery.view.View;
import ru.gb.toys_lottery.view.ui.admin.AdminConsoleUI;
import ru.gb.toys_lottery.view.ui.user.UserConsoleUI;

public class Main {
    public static void main(String[] args) {
        View view;
        if (args.length
                != 0
                && (args[0].equalsIgnoreCase("/admin")
                || args[0].equalsIgnoreCase("-admin"))) {
            view = new AdminConsoleUI();
        } else {
            view = new UserConsoleUI();
        }
        view.start();
    }
}