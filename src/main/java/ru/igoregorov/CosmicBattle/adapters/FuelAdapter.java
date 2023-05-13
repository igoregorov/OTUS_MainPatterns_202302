package ru.igoregorov.CosmicBattle.adapters;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.igoregorov.CosmicBattle.Properties.Fuel;
import ru.igoregorov.CosmicBattle.Properties.Properties;
import ru.igoregorov.enums.PropertiesValue;

@AllArgsConstructor
@NoArgsConstructor
public class FuelAdapter implements Fuel {
    Properties fuelObjects;

    @Override
    public Double getFuel() {
        return (Double) fuelObjects.getProperty(PropertiesValue.FUEL_VOLUME.getCode());
    }

    @Override
    public void setFuel(Double fuel) {
        fuelObjects.setProperty(PropertiesValue.FUEL_VOLUME.getCode(), fuel);
    }

    @Override
    public Double getDFuel() {
        return (Double) fuelObjects.getProperty(PropertiesValue.FUEL_DISTRICT.getCode());
    }

    @Override
    public void setDFuel(Double dFuel) {
        fuelObjects.setProperty(PropertiesValue.FUEL_DISTRICT.getCode(), dFuel);
    }
}
