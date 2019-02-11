package Logging;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by james on 2/10/2019.
 */
public class IFLogger {

    private Logger logger;

    public IFLogger(String className) {
        logger  = LogManager.getLogger(className);
    }

    public void fatal(String message) {
        logger.fatal(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void trace(String message) {
        logger.trace(message);
    }
}
