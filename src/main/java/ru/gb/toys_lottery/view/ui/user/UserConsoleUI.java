package ru.gb.toys_lottery.view.ui.user;

import ru.gb.toys_lottery.presenter.user.UserPresenter;
import ru.gb.toys_lottery.view.menu.user.UserMainMenu;
import ru.gb.toys_lottery.view.ui.ConsoleUI;
import ru.gb.toys_lottery.view.menu.Menu;

public class UserConsoleUI extends ConsoleUI {
    private final UserPresenter userPresenter;

    public UserConsoleUI() {
        super();
        this.userPresenter = new UserPresenter(this);
    }

    public void collectWinnings() {
        if (userPresenter.isEmptyWinnings()) {
            print("Корзина выигрышей пуста");
        } else {
            Integer id = input.getInt(
                    "Введите ID выигранной игрушки",
                    "^[0-9]|[1-9](\\d+)?$",
                    "Ошибка ввода. Введите положительное число");
            userPresenter.collectWinnings(id);
        }
    }

    @Override
    public void finish() {
        print("Приятного дня!");
        userPresenter.autoExportToObjectFile();
        work = false;
    }

    @Override
    public void getWinHistory() {
        userPresenter.getWinHistory();
    }

    public void playLottery() {
        userPresenter.playLottery();
    }

    public Menu previousMenu() {
        return previousMenu;
    }

    public void print(String data) {
        print(data, false);
    }

    public void print(String data, Boolean clearConsole) {
        if (clearConsole) {
            clearConsole();
        }
        System.out.println(data);
    }

    public void showMenu(Menu menu) {
        print(menu.getMenu());
        Integer choice = input.getInt(
                "Ввод",
                "\\d+",
                1,
                menu.countItems(),
                "Ошибка ввода. Данный пункт меню не найден");
        menu.execute(choice - 1);
    }

    @Override
    public void showPrizes() {
        userPresenter.showPrizes();
    }

    @Override
    public void showWinnings() {
        userPresenter.showWinnings();
    }

    @Override
    public void start() {
        userPresenter.autoImportFromObjectFile();
        currentMenu = new UserMainMenu(this);
        previousMenu = null;
        while (work) {
            welcome();
            showMenu(currentMenu);
        }
    }

    @Override
    public void welcome() {
        print("Главное меню");
    }
}
