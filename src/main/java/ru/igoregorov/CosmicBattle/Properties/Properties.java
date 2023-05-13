package ru.igoregorov.CosmicBattle.Properties;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public interface Properties {
    Map<String, Object> property = new HashMap<>();

    default void setProperty(String name, Object value) {
        property.put(name, value);
    }

    default Object getProperty(String name) {
        return property.get(name);
    }

    default Set<String> getAllProperties() {
        return property.keySet();
    }
}
