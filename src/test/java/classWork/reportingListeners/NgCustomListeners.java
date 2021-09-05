package classWork.reportingListeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class NgCustomListeners implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(NgCustomListeners.class);

    private String runID = "951";

    public void onTestStart(ITestResult result){

        LOGGER.info("Printing getName: " + result.getName());
        LOGGER.info("Printing getTestName: " + result.getTestName());
        LOGGER.info("Printing getMethod().getDescription(): " + result.getMethod().getDescription());

    }

    public void onTestSuccess(ITestResult result){

        LOGGER.info("Printing onSuccess: " + result.getStatus());
        TestRailReporter.reportResult(runID, result.getMethod().getDescription(), new Result(1));
    }

    public void onTestFailure(ITestResult result){

        LOGGER.info("Printing onFailure: " + result.getStatus());
        TestRailReporter.reportResult(runID, result.getMethod().getDescription(), new Result(5));
    }
}
