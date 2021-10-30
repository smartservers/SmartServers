package net.smartservers.connector;

public class SmartConnector {
    
    public static final String NAME = "SmartServices";
    public static final String GIT_VERSION = "DEV"; // A fallback for running in IDEs
    public static final String VERSION = "DEV"; // A fallback for running in IDEs

    private static SmartConnector instance;



    public static SmartConnector getInstance() {
        return instance;
    }
}
