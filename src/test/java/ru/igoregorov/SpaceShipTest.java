package ru.igoregorov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import ru.igoregorov.CosmicBattle.adapters.MovableAdapter;
import ru.igoregorov.CosmicBattle.commands.MoveCommand;
import ru.igoregorov.enums.KindException;
import ru.igoregorov.enums.PropertiesValue;
import ru.igoregorov.exceptions.CommandException;
import ru.igoregorov.exceptions.IllegalStateObjectException;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(MockitoExtension.class)
class SpaceShipTest extends SpaceShipTestData {

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMovable() throws CommandException {
        try {
            someThing.setProperty(PropertiesValue.POSITION.getCode(), vector);
            someThing.setProperty(PropertiesValue.VELOCITY.getCode(), velocity);
            someThing.setProperty(PropertiesValue.DENY_MOVE.getCode(), 0);
            MovableAdapter movableAdapter = new MovableAdapter(someThing);
            MoveCommand moveCommand = new MoveCommand(movableAdapter);
            moveCommand.execute();
        } catch (IllegalStateObjectException e) {
            throw new CommandException(e.getKindException());
        }

        assert result.equals(someThing.getProperty(PropertiesValue.POSITION.getCode()));
    }

    @Test
    void testMoveWithoutVelocity() {
        someThing.setProperty(PropertiesValue.POSITION.getCode(), vector);
        someThing.setProperty(PropertiesValue.VELOCITY.getCode(), null);
        someThing.setProperty(PropertiesValue.DENY_MOVE.getCode(), 0);

        Throwable thrown = assertThrows(IllegalStateObjectException.class, () -> {
            MovableAdapter movableAdapter = new MovableAdapter(someThing);
        });
        assertEquals(thrown.getMessage(), KindException.NO_MOVABLE_OBJECT.getDescription());
    }

    @Test
    void testMoveWithoutPosition() {
        someThing.setProperty(PropertiesValue.POSITION.getCode(), null);
        someThing.setProperty(PropertiesValue.VELOCITY.getCode(), velocity);
        someThing.setProperty(PropertiesValue.DENY_MOVE.getCode(), 0);

        Throwable thrown = assertThrows(IllegalStateObjectException.class, () -> {
            MovableAdapter movableAdapter = new MovableAdapter(someThing);
        });
        assertEquals(thrown.getMessage(), KindException.NO_MOVABLE_OBJECT.getDescription());
    }
    @Test
    void testMoveDeny() {
        someThing.setProperty(PropertiesValue.POSITION.getCode(), vector);
        someThing.setProperty(PropertiesValue.VELOCITY.getCode(), velocity);
        someThing.setProperty(PropertiesValue.DENY_MOVE.getCode(), 1);

        Throwable thrown = assertThrows(IllegalStateObjectException.class, () -> {
            MovableAdapter movableAdapter = new MovableAdapter(someThing);
        });
        assertEquals(thrown.getMessage(), KindException.NO_MOVABLE_OBJECT.getDescription());
    }
}
