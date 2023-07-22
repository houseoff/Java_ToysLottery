package ru.gb.toys_lottery.view.command;

public abstract class Command {
    protected String description;

    public String description() {
        return description;
    }

    public abstract void execute();
}
