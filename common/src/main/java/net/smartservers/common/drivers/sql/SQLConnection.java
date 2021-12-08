package net.smartservers.common.drivers.sql;

import net.smartservers.common.drivers.Driver;
import net.smartservers.common.drivers.DriverConfig;
import net.smartservers.common.drivers.DriverType;

@Driver.DriverInfo(type = DriverType.MYSQL)
public class SQLConnection extends Driver {

    public SQLConnection(DriverConfig driverConfig) {
        super(driverConfig);

        this.setLogger("SQL Connection");
    }

    @Override
    public void initConnection() {

    }
}
