package ru.igoregorov.CosmicBattle.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import ru.igoregorov.CosmicBattle.adapters.FuelAdapter;
import ru.igoregorov.CosmicBattle.adapters.MovableAdapter;
import ru.igoregorov.SpaceShipTestData;
import ru.igoregorov.enums.KindException;
import ru.igoregorov.exceptions.CommandException;
import ru.igoregorov.exceptions.IllegalStateObjectException;

import static org.junit.jupiter.api.Assertions.*;

class CheckFuelCommandTest extends SpaceShipTestData {
    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void execute() {
        FuelAdapter fuel = new FuelAdapter(someThing);
        fuel.setFuel(5D);
        fuel.setDFuel(15D);
        CheckFuelCommand command = new CheckFuelCommand(fuel);
        CommandException exception = assertThrows(CommandException.class, command::execute);
        assertEquals(KindException.NO_FUEL_FOR_MOVEMENT.getDescription(), exception.getMessage());
    }
}