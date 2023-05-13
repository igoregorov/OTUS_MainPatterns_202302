package ru.igoregorov.CosmicBattle.commands;

import ru.igoregorov.CosmicBattle.Properties.Command;
import ru.igoregorov.CosmicBattle.Properties.Rotable;
import ru.igoregorov.exceptions.CommandException;
import ru.igoregorov.exceptions.IllegalStateObjectException;

public class RotateCommand implements Command {
    Rotable someThing;
    public RotateCommand(Rotable someThing) {
        this.someThing = someThing;
    }

    public void execute() throws CommandException {
        try {
            if (someThing.getDirectionNumber() == 0) {
                return;
            }
            someThing.setDirection(
                    (someThing.getDirection() + (someThing.getAngularVelocity())) / someThing.getDirectionNumber()
            );
        } catch (IllegalStateObjectException e) {
            throw new CommandException(e.getKindException());
        }
    }
}
