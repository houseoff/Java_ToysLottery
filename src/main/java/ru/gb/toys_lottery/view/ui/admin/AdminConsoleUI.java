package ru.gb.toys_lottery.view.ui.admin;

import ru.gb.toys_lottery.presenter.admin.AdminPresenter;
import ru.gb.toys_lottery.view.menu.Menu;
import ru.gb.toys_lottery.view.menu.admin.AdminEditToyMenu;
import ru.gb.toys_lottery.view.menu.admin.AdminEmptyLotteryMainMenu;
import ru.gb.toys_lottery.view.menu.admin.AdminMainMenu;
import ru.gb.toys_lottery.view.ui.ConsoleUI;

import java.util.HashMap;

public class AdminConsoleUI extends ConsoleUI {
    private final AdminPresenter adminPresenter;

    public AdminConsoleUI() {
        super();
        adminPresenter = new AdminPresenter(this);
    }

    public void addToy() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", input.getString(
                "Введите наименование игрушки",
                ".*",
                "Ошибка ввода"));
        data.put("count", input.getString(
                "Введите количество игрушек",
                ".*",
                "Ошибка ввода. Введите положительное число"));
        data.put("probability", input.getString(
                "Введите вероятность выпадения игрушки в долях или %",
                "^((([0-9]|[1-9][0-9])(\\.\\d+)?|100(\\.0+)?)%)|(0(\\.\\d+)?|1(\\.0+)?)$",
                "Ошибка ввода. Допустимые диапазоны [0, 1], [0%, 100%]"));
        adminPresenter.addToy(data);
    }

    public void clearLotteryResults() {
        adminPresenter.clearLotteryResults();
    }

    public void clearLotteryToys() {
        adminPresenter.clearLotteryToys();
    }

    public void clearWinHistory() {
        adminPresenter.clearWinHistory();
    }

    public void editToy() {
        previousMenu = currentMenu;
        currentMenu = new AdminEditToyMenu(this);
        cacheId = input.getInt(
                "Введите ID игрушки",
                "^[0-9]|[1-9](\\d+)?$",
                "Ошибка ввода. Введите положительное число");
        if (adminPresenter.isExistId(cacheId)) {
            showMenu(currentMenu);
            back();
        } else {
            print("Игрушки с ID " + cacheId + " не найдено");
            cacheId = 0;
            back();
        }
    }

    public void editToyCount() {
        int count = input.getInt(
                "Введите новое количество игрушек",
                ".*",
                "Ошибка ввода");
        adminPresenter.editToyCount(cacheId, count);
    }

    public void editToyName() {
        String name = input.getString(
                "Введите новое наименование игрушки",
                ".*",
                "Ошибка ввода");
        adminPresenter.editToyName(cacheId, name);
    }

    public void editToyProbability() {
        String probability = input.getString(
                "Введите вероятность выпадения игрушки в долях или %",
                "^((([0-9]|[1-9][0-9])(\\.\\d+)?|100(\\.0+)?)%)|(0(\\.\\d+)?|1(\\.0+)?)$",
                "Ошибка ввода. Допустимые диапазоны [0, 1], [0%, 100%]");
        adminPresenter.editToyProbability(cacheId, probability);
    }

    public void exportToObjectFile() {
        adminPresenter.exportToObjectFile(input.getString("Введите имя файла для экспорта"));
    }

    @Override
    public void finish() {
        print("Приятного дня");
        work = false;
    }

    public boolean getSaveState() {
        return adminPresenter.getSaveState();
    }

    @Override
    public void getWinHistory() {
        adminPresenter.getWinHistory();
    }

    public void importFromObjectFile() {
        adminPresenter.importFromObjectFile(input.getString("Введите имя файла для импорта"));
    }

    @Override
    public Menu previousMenu() {
        return previousMenu;
    }

    @Override
    public void print(String data) {
        print(data, false);
    }

    public void print(String data, Boolean clearConsole) {
        if (clearConsole) {
            clearConsole();
        }
        System.out.println(data);
    }

    public void save() {
        adminPresenter.exportToObjectFile("lottery.db");
        adminPresenter.setSaveState(false);
    }

    @Override
    public void start() {
        previousMenu = null;
        welcome();
        while (work) {
            if (adminPresenter.isEmptyLotteryToys()) {
                currentMenu = new AdminEmptyLotteryMainMenu(this);
            } else currentMenu = new AdminMainMenu(this);
            showMenu(currentMenu);
        }
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
        adminPresenter.showPrizes();
    }

    @Override
    public void showWinnings() {
        adminPresenter.showWinnings();
    }

    @Override
    public void welcome() {
        print("Меню для администраторов программы");
    }
}
