package ru.igoregorov.CosmicBattle.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import ru.igoregorov.CosmicBattle.adapters.FuelAdapter;
import ru.igoregorov.SpaceShipTestData;
import ru.igoregorov.exceptions.CommandException;

import static org.junit.jupiter.api.Assertions.*;

class BurnFuelCommandTest extends SpaceShipTestData {
    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute() throws CommandException {
        FuelAdapter fuel = new FuelAdapter(someThing);
        fuel.setFuel(startFueld);
        fuel.setDFuel(districtFuel);
        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(fuel);
        burnFuelCommand.execute();
        assertEquals(endFuel, fuel.getFuel());
    }
}