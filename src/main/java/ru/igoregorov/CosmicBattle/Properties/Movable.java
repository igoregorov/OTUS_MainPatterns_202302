package ru.igoregorov.CosmicBattle.Properties;

import ru.igoregorov.utils.Vector;
import ru.igoregorov.exceptions.IllegalStateObjectException;

public interface Movable {
    Vector getPosition() throws IllegalStateObjectException;
    void setPosition(Vector newPosition);
    Vector getVelocity() throws IllegalStateObjectException;
    Vector getVelocityComplex() throws IllegalStateObjectException;
    int getMoveDirect() throws IllegalStateObjectException;
    int getMoveDirectNumber() throws IllegalStateObjectException;
}
