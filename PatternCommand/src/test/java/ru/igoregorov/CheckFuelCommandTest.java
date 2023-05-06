package ru.igoregorov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckFuelCommandTest {

    @Test
    void execute() throws CommandException {
        SomeThing someThing = new SomeThing();
        someThing.setFuel(5D);
        someThing.setDFuel(15D);
        CheckFuelCommand command = new CheckFuelCommand(someThing);
        CommandException exception = assertThrows(CommandException.class, command::execute);
        assertEquals(CommandException.Kind.NO_FUEL_FOR_MOVEMENT.getDescription(), exception.getMessage());
    }
}