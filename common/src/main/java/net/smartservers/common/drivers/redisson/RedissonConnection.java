package net.smartservers.common.drivers.redisson;

import net.smartservers.common.drivers.Driver;
import net.smartservers.common.drivers.DriverConfig;
import net.smartservers.common.drivers.DriverType;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;

@Driver.DriverInfo(type = DriverType.REDISSON)
public class RedissonConnection extends Driver {

    private RedissonClient connection;

    public RedissonConnection(DriverConfig driverConfig){
        super(driverConfig);

        initConnection();
    }

    @Override
    public void initConnection(){

        DriverConfig driverConfig = this.getDriverConfig();
        Config config = new Config();
        config.setCodec(new JsonJacksonCodec());
        config.setThreads(8);
        config.setNettyThreads(8);

        config.useSingleServer()
                .setAddress("redis://" + driverConfig.getHost() + ":" + driverConfig.getPort())
                .setDatabase(driverConfig.getDatabaseNumber())
                .setPassword(driverConfig.getPassword());


        connection = Redisson.create(config);

    }

    /**
     * Close and disconnect driver
     */
    public void closeConnection(){
        getRedissonClient().shutdown();
    }

    /**
     * Get main driver connection
     *
     * @return Redisson Client
     */
    public RedissonClient getRedissonClient(){
        return connection;
    }

}
