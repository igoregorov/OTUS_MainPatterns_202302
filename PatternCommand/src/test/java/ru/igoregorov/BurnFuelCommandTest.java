package ru.igoregorov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BurnFuelCommandTest {

    @Test
    void execute() throws CommandException {
        SomeThing someThing = new SomeThing();
        someThing.setFuel(15D);
        someThing.setDFuel(5D);
        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(someThing);
        burnFuelCommand.execute();
        assertEquals(10D, someThing.getFuel());
    }
}