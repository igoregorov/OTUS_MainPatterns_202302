package ru.igoregorov.exceptions;

import lombok.Getter;
import ru.igoregorov.enums.KindException;

@Getter
public class CommandException extends Exception {
    private final KindException kindException;
    public CommandException(KindException kind) {
        super(kind.getDescription(), null);
        this.kindException = kind;
    }
}