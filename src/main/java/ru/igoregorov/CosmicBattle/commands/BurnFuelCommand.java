package ru.igoregorov.CosmicBattle.commands;

import ru.igoregorov.CosmicBattle.Properties.Command;
import ru.igoregorov.CosmicBattle.Properties.Fuel;
import ru.igoregorov.exceptions.CommandException;

public class BurnFuelCommand implements Command {
    Fuel obj;
    public BurnFuelCommand(Fuel obj) {
        this.obj = obj;
    }
    @Override
    public void execute() throws CommandException {
        obj.setFuel(obj.getFuel() - obj.getDFuel());
    }
}