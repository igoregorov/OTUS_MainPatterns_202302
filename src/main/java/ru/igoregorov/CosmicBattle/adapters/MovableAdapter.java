package ru.igoregorov.CosmicBattle.adapters;

import lombok.Getter;
import ru.igoregorov.CosmicBattle.Properties.Movable;
import ru.igoregorov.CosmicBattle.Properties.Properties;
import ru.igoregorov.utils.Vector;
import ru.igoregorov.enums.KindException;
import ru.igoregorov.enums.PropertiesValue;
import ru.igoregorov.exceptions.IllegalStateObjectException;
import ru.igoregorov.utils.Utils;

import static java.util.Objects.nonNull;

@Getter
public class MovableAdapter implements Movable {
    Properties movableObject;
    public MovableAdapter(Properties properties) throws IllegalStateObjectException {
        if (!isMovable(properties)) throw new IllegalStateObjectException(KindException.NO_MOVABLE_OBJECT);
        this.movableObject = properties;
    }

    public Vector getPosition() throws IllegalStateObjectException {
        try {
            return (Vector) movableObject.getProperty(PropertiesValue.POSITION.getCode());
        } catch (NumberFormatException e) {
            throw new IllegalStateObjectException(KindException.NO_VECTOR_DATA, e);
        }
    }

    public void setPosition(Vector newPosition) {
        movableObject.setProperty(PropertiesValue.POSITION.getCode(), newPosition);
    }

    public Vector getVelocityComplex() throws IllegalStateObjectException {
        int d = getMoveDirect();
        int n = getMoveDirectNumber();
        Vector v = (Vector) movableObject.getProperty(PropertiesValue.VELOCITY.getCode());
        Double absVelocity = v.getLength();
        double alpha = (d/360.0)*n;
        return new Vector(
                Vector.castInteger(Math.round(absVelocity*Math.cos(alpha))),
                Vector.castInteger(Math.round(absVelocity*Math.sin(alpha)))
        );
    }
    public Vector getVelocity() throws IllegalStateObjectException {
        try {
            return (Vector) movableObject.getProperty(PropertiesValue.VELOCITY.getCode());
        } catch (NumberFormatException e) {
            throw new IllegalStateObjectException(KindException.NO_VECTOR_DATA, e);
        }
    }

    public int getMoveDirect() throws IllegalStateObjectException {
        try {
            return (int) Utils.nvl(movableObject.getProperty(PropertiesValue.MOVE_DIRECT.getCode()), 0);
        } catch (NumberFormatException e) {
            throw new IllegalStateObjectException(KindException.NO_INT_DATA, e);
        }
    }

    public int getMoveDirectNumber() throws IllegalStateObjectException {
        try {
            return (int) Utils.nvl(movableObject.getProperty(PropertiesValue.MOVE_DIRECT_NUMBER.getCode()), 0);
        } catch (NumberFormatException e) {
            throw new IllegalStateObjectException(KindException.NO_INT_DATA, e);
        }
    }

    private static boolean isMovable(Properties obj) {
        return nonNull(obj.getProperty(PropertiesValue.POSITION.getCode())) &&
                nonNull(obj.getProperty(PropertiesValue.VELOCITY.getCode())) &&
                !isDenyMove(obj);
    }

    private static boolean isDenyMove(Properties obj) {
        return nonNull(obj.getProperty(PropertiesValue.DENY_MOVE.getCode())) &&
                obj.getProperty(PropertiesValue.DENY_MOVE.getCode()).equals(1);
    }
}
