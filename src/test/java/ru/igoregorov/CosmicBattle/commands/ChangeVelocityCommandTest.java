package ru.igoregorov.CosmicBattle.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import ru.igoregorov.SpaceShipTestData;
import ru.igoregorov.enums.PropertiesValue;
import ru.igoregorov.exceptions.CommandException;
import ru.igoregorov.utils.Vector;

import static ru.igoregorov.enums.PropertiesValue.VELOCITY;


class ChangeVelocityCommandTest extends SpaceShipTestData {
    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute() throws CommandException {
        Vector velocity = new Vector(1,2);
        ChangeVelocityCommand changeVelocityCommand = new ChangeVelocityCommand(someThing, velocity);
        changeVelocityCommand.execute();
        assert newVelocity.equals(someThing.getProperty(VELOCITY.getCode()));
    }
}