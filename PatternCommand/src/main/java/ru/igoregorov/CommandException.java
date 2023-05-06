package ru.igoregorov;

import lombok.Getter;

public class CommandException extends Exception {
    public CommandException(Kind kind) {
        super(kind.getDescription(), null);
    }

    public enum Kind {
        NO_FUEL_FOR_MOVEMENT("нет топлива для движения"),
        ;

        @Getter
        private final String description;
        Kind(String description) {
            this.description = description;
        }
    }
}
