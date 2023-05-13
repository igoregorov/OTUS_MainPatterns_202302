package ru.igoregorov.CosmicBattle.commands;

import ru.igoregorov.CosmicBattle.Properties.Command;
import ru.igoregorov.CosmicBattle.Properties.Fuel;
import ru.igoregorov.enums.KindException;
import ru.igoregorov.exceptions.CommandException;

import static ru.igoregorov.utils.Utils.isZero;

public class CheckFuelCommand implements Command {
    Fuel obj;
    public  CheckFuelCommand(Fuel obj) {
        this.obj = obj;
    }
    @Override
    public void execute() throws CommandException {
        if (isZero(obj.getFuel()) || isZero(obj.getFuel() - obj.getDFuel()) || (obj.getFuel() - obj.getDFuel()) < 0) {
            throw new CommandException(KindException.NO_FUEL_FOR_MOVEMENT);
        }
    }
}