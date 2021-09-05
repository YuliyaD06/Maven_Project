package classWork.logging;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class L4J2Logging {

    private static final Logger LOGGER =
            LogManager.getLogger(L4J2Logging.class.getName());

    public static void main(String[] args) {

        LOGGER.fatal("Сообщение с уровнем FATAL");
        LOGGER.error("Сообщение с уровнем ERROR");
        LOGGER.warn("Сообщение с уровнем WARN");
        LOGGER.info("Сообщение с уровнем INFO");
        LOGGER.debug("Сообщение с уровнем DEBUG");
        LOGGER.trace("Сообщение с уровнем TRACE");

    }

}
