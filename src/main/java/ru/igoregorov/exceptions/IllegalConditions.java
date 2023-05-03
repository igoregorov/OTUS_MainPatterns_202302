package ru.igoregorov.exceptions;

import lombok.Getter;

public class IllegalConditions extends Exception {
    public IllegalConditions(Kind kind) {
        super(kind.getDescription(), null);
    }

    public enum Kind {
        INFINIT_SOLUTION("Бесконечно много решений"),
        NO_SOLUTION("Не имеет решений"),
        NO_POLYNOM("Это не квадратное уравнение"),
        NO_NUMBER_COEF("Не числовой коэффициент"),
        ;

        @Getter
        private final String description;
        Kind(String description) {
            this.description = description;
        }
    }
}
