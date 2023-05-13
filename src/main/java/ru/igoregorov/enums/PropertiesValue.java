package ru.igoregorov.enums;

import lombok.Getter;
import ru.igoregorov.CosmicBattle.Properties.Fuel;
import ru.igoregorov.CosmicBattle.Properties.Movable;
import ru.igoregorov.CosmicBattle.Properties.Rotable;

public enum PropertiesValue {
    POSITION("Position", Movable.class),
    MOVE_DIRECT("MoveDirect", Movable.class),
    MOVE_DIRECT_NUMBER("MoveDirectNumber", Movable.class),
    VELOCITY("Velocity", Movable.class),
    DENY_MOVE("NoMovable", Movable.class),
    DIRECTION("Direction", Rotable.class),
    DIRECTION_NUMBER("DirectionNumber", Rotable.class),
    ANGULAR_VELOCITY("AngularVelocity", Rotable.class),
    FUEL_VOLUME("Fuel", Fuel.class),
    FUEL_DISTRICT("FuelDistrict", Fuel.class),

    ;

    @Getter
    private final Class clazz;
    @Getter
    private final String code;
    PropertiesValue(String code, Class clazz) {
        this.code = code;
        this.clazz = clazz;
    }
}
