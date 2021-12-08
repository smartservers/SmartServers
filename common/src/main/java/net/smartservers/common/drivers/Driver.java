package net.smartservers.common.drivers;

import lombok.Getter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.logging.Logger;

@Getter
public abstract class Driver {

    private final DriverType type;
    private final DriverConfig driverConfig;

    public Logger logs;

    /**
     * Initial driver and config
     *
     * @param driverConfig Driver Config
     */
    public Driver(DriverConfig driverConfig) {
        DriverInfo info = this.getClass().getAnnotation(DriverInfo.class);

        if(info == null) {
            throw new NullPointerException("Not driver type found");
        }

        this.type = info.type();
        this.driverConfig = driverConfig;

        this.logs = Logger.getLogger(type.toString() + " DRIVER");
    }

    /**
     * Set Driver logger name
     *
     * @param name of the logger
     */
    public void setLogger(String name) {
        this.logs = Logger.getLogger(name);
    }

    /**
     * Initialize the connection to the database
     */
    public abstract void initConnection();

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface DriverInfo {

        /**
         * Get the driver type
         *
         * @return Driver Type
         */
        DriverType type();

    }
}
