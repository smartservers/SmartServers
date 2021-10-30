package net.smartservers.connector;

public interface SmartLogger {

    /**
     * Logs a severe message to console
     *
     * @param message the message to log
     */
    void severe(String message);

    /**
     * Logs a severe message and an exception to console
     *
     * @param message the message to log
     * @param error the error to throw
     */
    void severe(String message, Throwable error);

    /**
     * Logs an error message to console
     *
     * @param message the message to log
     */
    void error(String message);

    /**
     * Logs an error message and an exception to console
     *
     * @param message the message to log
     * @param error the error to throw
     */
    void error(String message, Throwable error);

    /**
     * Logs a warning message to console
     *
     * @param message the message to log
     */
    void warning(String message);

    /**
     * Logs an info message to console
     *
     * @param message the message to log
     */
    void info(String message);

    /**
     * Logs a debug message to console
     *
     * @param message the message to log
     */
    void debug(String message);

    /**
     * Sets if the logger should print debug messages
     *
     * @param debug if the logger should print debug messages
     */
    void setDebug(boolean debug);

    /**
     * If debug is enabled for this logger
     */
    boolean isDebug();

}
