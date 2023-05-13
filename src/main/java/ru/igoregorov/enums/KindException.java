package ru.igoregorov.enums;

import lombok.Getter;
import ru.igoregorov.CosmicBattle.Properties.Fuel;
import ru.igoregorov.exceptions.IllegalConditions;
import ru.igoregorov.exceptions.IllegalStateObjectException;

public enum KindException {
    INFINIT_SOLUTION("1 Бесконечно много решений", IllegalConditions.class),
    NO_SOLUTION("2 Не имеет решений", IllegalConditions.class),
    NO_POLYNOM("3 Это не квадратное уравнение", IllegalConditions.class),
    NO_NUMBER_COEF("4 Не числовой коэффициент", IllegalConditions.class),
    NO_MOVABLE_OBJECT("5 Это не может двигаться", IllegalStateObjectException.class),
    NO_ROTABLE_OBJECT("6 Это не может поворачиваться", IllegalStateObjectException.class),
    NO_VECTOR_DATA("7 Позиция может быть задана только в формате Vector(x,y)", IllegalStateObjectException.class),
    NO_INT_DATA("8 Свойство может быть задано только в формате x - целое", IllegalStateObjectException.class),
    NO_FUEL_FOR_MOVEMENT("9 нет топлива для движения", Fuel.class),
    ;

    @Getter
    private final String description;
    @Getter
    private final Class throwableClass;
    KindException(String description, Class throwable) {
        this.throwableClass = throwable;
        this.description = description;
    }
}
