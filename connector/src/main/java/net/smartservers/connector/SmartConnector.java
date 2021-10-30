package net.smartservers.connector;

import net.smartservers.common.SmartPlatformType;

public class SmartConnector {
    
    public static final String NAME = "SmartServices";
    public static final String GIT_VERSION = "DEV"; // A fallback for running in IDEs
    public static final String VERSION = "DEV"; // A fallback for running in IDEs

    private static SmartConnector instance;

    private final SmartPlatformType platformType;

    public SmartConnector(SmartPlatformType platformType) {
        this.platformType = platformType;
    }

    public static SmartConnector getInstance() {
        return instance;
    }
}
