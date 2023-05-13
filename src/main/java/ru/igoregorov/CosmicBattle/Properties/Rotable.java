package ru.igoregorov.CosmicBattle.Properties;

import ru.igoregorov.exceptions.IllegalConditions;
import ru.igoregorov.exceptions.IllegalStateObjectException;

public interface Rotable {
    int getDirection() throws IllegalStateObjectException;
    int getAngularVelocity() throws IllegalStateObjectException;
    int getDirectionNumber() throws IllegalStateObjectException;
    void setDirection(int newDirection);
}
