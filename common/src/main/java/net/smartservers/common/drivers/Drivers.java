package net.smartservers.common.drivers;

import lombok.Getter;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class Drivers<T> {

    @Getter
    private final DriverConfig driverConfig;

    private Class<T> result = null;

    /**
     * Construct driver with driver configuration
     *
     * @param driverConfig Driver Configuration
     */
    public Drivers(DriverConfig driverConfig) {
        this.driverConfig = driverConfig;

        Reflections reflections = new Reflections("net.smartservers.common.drivers");

        Set<Class<? extends Driver>> allClasses =
                reflections.getSubTypesOf(Driver.class);

        allClasses.forEach(clazz -> {
            Driver.DriverInfo info = clazz.getAnnotation(Driver.DriverInfo.class);

            //Check if class have driver annotation
            if (info != null) {
                if(info.type() == driverConfig.getDriverType()) {
                    result = (Class<T>) clazz;
                }
            }

        });
    }

    /**
     * Get the class with the connection initialized to the database
     *
     * @return Extends driver class
     */
    public T get() {
        try {
            return result.getConstructor(DriverConfig.class).newInstance(driverConfig);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }
}
