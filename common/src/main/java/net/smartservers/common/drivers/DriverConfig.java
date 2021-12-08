package net.smartservers.common.drivers;

import lombok.Getter;
import lombok.Setter;

public class DriverConfig {

    @Getter
    private final String host, port, password;

    @Getter
    private final DriverType driverType;

    @Getter
    @Setter
    private String user;

    private Object database;

    /**
     *
     *  Driver Configuration with credentials and database info
     *
     * @param type DriverType (MYSQL, ...)
     * @param host Host name (127.0.0.1)
     * @param port Port number
     * @param password Password access
     */
    public DriverConfig(DriverType type, String host, String port, String password) {
        this.driverType = type;
        this.host = host;
        this.port = port;
        this.password = password;
    }

    /**
     * Set database name or number
     *
     * @param database Name or Number (For Redis)
     * @return this DriverConfig
     */
    public DriverConfig setDatabase(Object database) {
        this.database = database;

        return this;
    }

    /**
     * Get database name
     *
     * @return name
     */
    public String getDatabase() {
        return (String) database;
    }

    /**
     * Get redis database number
     *
     * @return Database number
     */
    public int getDatabaseNumber() {
        return (int) database;
    }
}
