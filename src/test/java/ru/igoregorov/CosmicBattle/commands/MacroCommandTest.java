package ru.igoregorov.CosmicBattle.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import ru.igoregorov.CosmicBattle.adapters.FuelAdapter;
import ru.igoregorov.CosmicBattle.adapters.MovableAdapter;
import ru.igoregorov.SpaceShipTestData;
import ru.igoregorov.exceptions.CommandException;
import ru.igoregorov.exceptions.IllegalStateObjectException;

import java.util.Arrays;


import static ru.igoregorov.enums.PropertiesValue.*;

class MacroCommandTest extends SpaceShipTestData {
    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute() throws CommandException {
        FuelAdapter fuel = new FuelAdapter(someThing);
        fuel.setFuel(startFueld);
        fuel.setDFuel(districtFuel);
        CheckFuelCommand checkFuelCommand = new CheckFuelCommand(fuel);
        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(fuel);
        try {
            someThing.setProperty(POSITION.getCode(), vector);
            someThing.setProperty(VELOCITY.getCode(), velocity);
            someThing.setProperty(DENY_MOVE.getCode(), 0);
            MovableAdapter move = new MovableAdapter(someThing);
            MoveCommand moveCommand = new MoveCommand(move);
            MacroCommand macroCommand = new MacroCommand(Arrays.asList(checkFuelCommand, moveCommand, burnFuelCommand));
            macroCommand.execute();
        } catch (IllegalStateObjectException e) {
            throw new CommandException(e.getKindException());
        }
        assert result.equals(someThing.getProperty(POSITION.getCode()));
        assert endFuel.equals(someThing.getProperty(FUEL_VOLUME.getCode()));
    }

}