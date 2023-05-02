package ru.igoregorov;

import static ru.igoregorov.utils.Utils.isZero;

public class CheckFuelCommand implements Command {
    Fuel obj;
    public  CheckFuelCommand(Fuel obj) {
        this.obj = obj;
    }
    @Override
    public void execute() throws CommandException{
        if (isZero(obj.getFuel()) || isZero(obj.getFuel() - obj.getDFuel())) {
            throw new CommandException(CommandException.Kind.NO_FUEL_FOR_MOVEMENT);
        }
    }
}
