package ru.igoregorov.exceptions;

import ru.igoregorov.enums.KindException;

public class IllegalConditions extends Exception {

    public IllegalConditions(KindException kind) {
        super(kind.getDescription(), null);
    }
}
