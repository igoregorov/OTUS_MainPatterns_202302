package ru.igoregorov;

import static ru.igoregorov.utils.Utils.isZero;

public class CheckFuelCommand implements Command {
    Fuel obj;
    public  CheckFuelCommand(Fuel obj) {
        this.obj = obj;
    }
    @Override
    public void execute() throws CommandException{
        System.out.println(obj.getFuel());
        System.out.println(obj.getDFuel());
        System.out.println(isZero(obj.getFuel()) || isZero(obj.getFuel() - obj.getDFuel()) ||
                (obj.getFuel() - obj.getDFuel()) < 0);
        if (isZero(obj.getFuel()) || isZero(obj.getFuel() - obj.getDFuel()) || (obj.getFuel() - obj.getDFuel()) < 0) {
            throw new CommandException(CommandException.Kind.NO_FUEL_FOR_MOVEMENT);
        }
    }
}
