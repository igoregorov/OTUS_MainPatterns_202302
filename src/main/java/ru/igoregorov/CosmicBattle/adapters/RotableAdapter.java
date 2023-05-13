package ru.igoregorov.CosmicBattle.adapters;

import lombok.Getter;
import ru.igoregorov.CosmicBattle.Properties.Properties;
import ru.igoregorov.CosmicBattle.Properties.Rotable;
import ru.igoregorov.enums.KindException;
import ru.igoregorov.enums.PropertiesValue;
import ru.igoregorov.exceptions.IllegalStateObjectException;

import static java.util.Objects.nonNull;

@Getter
public class RotableAdapter implements Rotable {
    Properties rotableObject;
    public RotableAdapter(Properties properties) throws IllegalStateObjectException {
        if (!isRotable(properties)) throw new IllegalStateObjectException(KindException.NO_ROTABLE_OBJECT);
        this.rotableObject = properties;
    }

    public int getDirection() throws IllegalStateObjectException {
        try {
            return (int) rotableObject.getProperty(PropertiesValue.DIRECTION.getCode());
        } catch (NumberFormatException e) {
            throw new IllegalStateObjectException(KindException.NO_INT_DATA, e);
        }
    }

    public int getAngularVelocity() throws IllegalStateObjectException {
        try {
            return (int) rotableObject.getProperty(PropertiesValue.ANGULAR_VELOCITY.getCode());
        } catch (NumberFormatException e) {
            throw new IllegalStateObjectException(KindException.NO_INT_DATA, e);
        }
    }
    public int getDirectionNumber() throws IllegalStateObjectException {
        try {
            return (int) rotableObject.getProperty(PropertiesValue.DIRECTION_NUMBER.getCode());
        } catch (NumberFormatException e) {
            throw new IllegalStateObjectException(KindException.NO_INT_DATA, e);
        }
    }
    public void setDirection(int newDirection) {
        rotableObject.setProperty(PropertiesValue.DIRECTION.getCode(), newDirection);
    }
    public static boolean isRotable(Properties obj) {
        return nonNull(obj.getProperty(PropertiesValue.DIRECTION.getCode())) &&
                nonNull(obj.getProperty(PropertiesValue.ANGULAR_VELOCITY.getCode())) &&
                nonNull(obj.getProperty(PropertiesValue.DIRECTION_NUMBER.getCode()));
    }
}
