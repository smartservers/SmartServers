package net.smartservers.connector;

import lombok.Getter;
import net.smartservers.common.SmartPlatformType;

public class SmartConnector {

    @Getter
    public static final String NAME = "SmartServices";

    @Getter
    public static final String GIT_VERSION = "DEV"; // A fallback for running in IDEs

    @Getter
    public static final String VERSION = "DEV"; // A fallback for running in IDEs

    @Getter
    private static SmartConnector instance;

    @Getter
    private final SmartPlatformType platformType;

    public SmartConnector(SmartPlatformType platformType) {
        this.platformType = platformType;
    }
}
