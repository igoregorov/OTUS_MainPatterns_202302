package ru.igoregorov.CosmicBattle.commands;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ru.igoregorov.CosmicBattle.Properties.Command;
import ru.igoregorov.CosmicBattle.Properties.Properties;
import ru.igoregorov.exceptions.CommandException;
import ru.igoregorov.utils.Vector;

import static ru.igoregorov.enums.PropertiesValue.VELOCITY;

@AllArgsConstructor
@NoArgsConstructor
public class ChangeVelocityCommand implements Command {

    private Properties someThing;
    private Vector newVelocity;
    @Override
    public void execute() throws CommandException {
        Vector velocity = (Vector) someThing.getProperty(VELOCITY.getCode());
        velocity = velocity.plus(newVelocity);
        someThing.setProperty(VELOCITY.getCode(), velocity);
    }
}
