package ru.igoregorov;

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
