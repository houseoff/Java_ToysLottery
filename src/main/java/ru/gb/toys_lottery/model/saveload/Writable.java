package ru.gb.toys_lottery.model.saveload;

import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    void write(Serializable obj, Writing handler) throws IOException;
}
