package ru.gb.toys_lottery.model.saveload;

import java.io.IOException;

public interface Reading<T> {
    T read() throws IOException, ClassNotFoundException;
}
