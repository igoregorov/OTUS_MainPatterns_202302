package ru.igoregorov.CosmicBattle;

import ru.igoregorov.CosmicBattle.Properties.Properties;
import ru.igoregorov.enums.PropertiesValue;
import ru.igoregorov.utils.Vector;

public class SpaceShipObject implements Properties {

    public SpaceShipObject() {
        setProperty(PropertiesValue.POSITION.getCode(), new Vector(0,0));
        setProperty(PropertiesValue.VELOCITY.getCode(), 0);
        setProperty(PropertiesValue.MOVE_DIRECT.getCode(), 0);
        setProperty(PropertiesValue.MOVE_DIRECT_NUMBER.getCode(), 0);
        setProperty(PropertiesValue.DIRECTION.getCode(), 0);
        setProperty(PropertiesValue.DIRECTION_NUMBER.getCode(), 0);
        setProperty(PropertiesValue.ANGULAR_VELOCITY.getCode(), 0);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : getAllProperties()) {
            stringBuilder.append(str + " = " + getProperty(str));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
