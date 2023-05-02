package ru.igoregorov;

public class CommandMove implements Command {

    private Double dX;
    private Double dY;
    private Position obj;
    CommandMove(Position obj, Double dX, Double dY) {
        this.obj = obj;
        this.dX = dX;
        this.dY = dY;
    }
    @Override
    public void execute() throws CommandException {
        obj.setX(obj.getX() + this.dX);
        obj.setY(obj.getY() + this.dY);
    }
}
