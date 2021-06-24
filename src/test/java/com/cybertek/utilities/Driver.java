package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    /*
    Creating the private constructor so this class object
    is not reachable from outside
     */
    private Driver() {}

    /*
    Making our 'driver' instance private so that it is nor reachable from outside of the class.
    We maki it static, because we want it to run before everything else, and also we will use it in a static method
     */
    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            /*
            We read out browser type from configuration.properties file using
            .getProperty method we creating in ConfigurationReader class.
             */
            String browserType = ConfigurationReader.getProperty("browser");
            String env = ConfigurationReader.getProperty("env");
            /*
            Depending on the browser type out switch statement will determine
            to open specific type of browser/driver
             */
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    driver.get(env);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }
        /*
        Same driver instance will be returned every time we call Driver.getDriver(); method
         */
        return driver;
    }

    /*
This method makes sure we have some form of driver session or driver id has
Either null or not null it must exist
 */
    public static void closeDriver() {
        if (driver!=null) {
            driver.quit();
            driver=null;
        }

    }

}
