package ru.igoregorov;

import org.mockito.Mock;
import org.mockito.Spy;
import ru.igoregorov.CosmicBattle.Properties.Fuel;
import ru.igoregorov.CosmicBattle.Properties.Properties;
import ru.igoregorov.CosmicBattle.adapters.FuelAdapter;
import ru.igoregorov.utils.Vector;

public class SpaceShipTestData {
    @Spy
    protected Properties someThing;
    protected final Vector vector = new Vector(12, 5);
    protected final Vector velocity = new Vector(-7, 3);
    protected final Vector changeVelocity = new Vector(1, 2);
    protected final Vector newVelocity = new Vector(-6, 5);
    protected final Vector result =  new Vector(5, 8);
    protected final Double startFueld = 15D;
    protected final Double endFuel = 10D;
    protected final Double districtFuel = 5D;

}
