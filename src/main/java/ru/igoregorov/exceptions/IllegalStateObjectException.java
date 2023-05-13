package ru.igoregorov.exceptions;

import lombok.Getter;
import ru.igoregorov.enums.KindException;

@Getter
public class IllegalStateObjectException extends Exception {
    private final KindException kindException;
    public IllegalStateObjectException(KindException kind) {
        super(kind.getDescription(), null);
        this.kindException = kind;
    }
    public IllegalStateObjectException(KindException kind, Throwable e) {
        super(kind.getDescription(), e);
        this.kindException = kind;
    }
}
