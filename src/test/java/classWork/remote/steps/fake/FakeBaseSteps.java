package classWork.remote.steps.fake;

import driver.Config;
import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FakeBaseSteps {
    private static final Logger LOGGER = LogManager.getLogger(FakeBaseSteps.class);

    @Before
    public void beforeTest(){
        LOGGER.info("Initializing Webdriver..");
        Driver.initDriver(Config.CHROME);
        //Driver.initDriver(Config.REMOTE);
    }

    @After
    public void afterTest(){
        LOGGER.info("Killing WEbdriver..");
        Driver.destroy();
    }
}
