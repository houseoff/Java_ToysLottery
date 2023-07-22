package ru.gb.toys_lottery.model.saveload;

import java.io.IOException;
import java.io.Serializable;

public interface Writing {
    void write(Serializable obj) throws IOException;
}
