package ru.igoregorov;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SomeThing implements Position, Fuel {
    private CommandManager commandManager;
    private Double x;
    private Double y;
    private Double fuel;

    public void move(Double dx, Double dy) {
        commandManager.move(this, dx, dy);
    }
}
