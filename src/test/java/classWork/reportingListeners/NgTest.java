package classWork.reportingListeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NgCustomListeners.class)
public class NgTest {

    private static final Logger LOGGER = LogManager.getLogger(NgTest.class);

    @Test(description = "94311") //testNg
    public void FirstTest(){

        LOGGER.info("Executing ");
        Assert.assertTrue(true);

    }

    @Test(description = "94312")  //testNg
    public void SecondTest(){

        LOGGER.info("Executing ");
        Assert.assertTrue(false);

    }

}
