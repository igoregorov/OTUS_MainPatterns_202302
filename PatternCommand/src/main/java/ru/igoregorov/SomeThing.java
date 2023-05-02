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
    private Double dFuel;

    public void move(Double dx, Double dy) {
        this.dFuel = Math.sqrt(dx*dx + dy*dy);
        commandManager.move(this, dx, dy);
    }
}
