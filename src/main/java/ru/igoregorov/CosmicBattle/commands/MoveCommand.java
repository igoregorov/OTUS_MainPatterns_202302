package ru.igoregorov.CosmicBattle.commands;

import ru.igoregorov.CosmicBattle.Properties.Command;
import ru.igoregorov.CosmicBattle.Properties.Movable;
import ru.igoregorov.enums.KindException;
import ru.igoregorov.exceptions.CommandException;
import ru.igoregorov.exceptions.IllegalStateObjectException;

public class MoveCommand implements Command {
    Movable someThing;
    public MoveCommand(Movable someThing) {
        this.someThing = someThing;
    }

    public void execute() throws CommandException {
        try {
            someThing.setPosition(someThing.getPosition().plus(someThing.getVelocity()));
        } catch (IllegalStateObjectException e) {
            throw new CommandException(e.getKindException());
        }
    }
}
