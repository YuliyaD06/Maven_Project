package classWork.taf;

import driver.Config;
import driver.Driver;

public class GlobalConditions {

    static {
        doBeforeAll();
        doAfterAll();
    }

    private static void doBeforeAll(){
        Driver.initDriver(Config.valueOf(System.getProperty("BROWSER")));
    }

    private static void doAfterAll(){
        Runtime.getRuntime().addShutdownHook(new Thread(() ->{
            System.out.println("###################################ShutDownHook");
            Driver.destroy();
        }));
    }


}
