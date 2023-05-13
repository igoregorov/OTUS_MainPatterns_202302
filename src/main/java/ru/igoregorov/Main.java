package ru.igoregorov;

import ru.igoregorov.CosmicBattle.adapters.MovableAdapter;
import ru.igoregorov.CosmicBattle.commands.MoveCommand;
import ru.igoregorov.CosmicBattle.adapters.RotableAdapter;
import ru.igoregorov.CosmicBattle.commands.RotateCommand;
import ru.igoregorov.CosmicBattle.SpaceShipObject;
import ru.igoregorov.exceptions.CommandException;
import ru.igoregorov.utils.Vector;
import ru.igoregorov.enums.PropertiesValue;
import ru.igoregorov.exceptions.IllegalStateObjectException;

public class Main {
    public static void main(String[] args) {
        SpaceShipObject object = new SpaceShipObject();
        object.setProperty(PropertiesValue.POSITION.getCode(), new Vector(4, 0));
        object.setProperty(PropertiesValue.MOVE_DIRECT.getCode(), 0);
        object.setProperty(PropertiesValue.VELOCITY.getCode(), new Vector(5, 3));
        object.setProperty(PropertiesValue.ANGULAR_VELOCITY.getCode(), 7);
        object.setProperty(PropertiesValue.DIRECTION_NUMBER.getCode(), 3);
        try {
            MovableAdapter adapter = new MovableAdapter(object);
            MoveCommand moveCommand = new MoveCommand(adapter);
            moveCommand.execute();
            moveCommand.execute();
            RotableAdapter rotableAdapter = new RotableAdapter(object);
            RotateCommand rotateCommand = new RotateCommand(rotableAdapter);
            rotateCommand.execute();
            rotateCommand.execute();
            rotateCommand.execute();
            System.out.println(object);
        } catch (IllegalStateObjectException | CommandException e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }
    }
}
