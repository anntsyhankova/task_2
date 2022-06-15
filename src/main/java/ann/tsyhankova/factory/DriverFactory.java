package ann.tsyhankova.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getInstance() {

        if (driver == null) {

            driver =  getInstance("chrome");
        }

        return driver;
    }
    public static WebDriver getInstance(String driverName) {

        if (driver == null) {

            switch (driverName.toLowerCase()) {
                case "remote":
                    ChromeOptions remoteOptions = new ChromeOptions();
                    remoteOptions.setHeadless(true);
                    try {
                        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), remoteOptions, false);
                    }
                    catch (MalformedURLException e){
                         //log.error("Cannot initialize RemoteWebDriver");
                        System.err.println("Cannot initialize RemoteWebDriver");
                    }
                    break;
                case "local":
                    String pathToBinary = "src/main/resources/drivers/chromedriver.exe";
                    ChromeOptions options = new ChromeOptions();
                    //options.setBinary(pathToBinary);
                    options.setHeadless(false);
                    options.setAcceptInsecureCerts(true);
                    System.setProperty("webdriver.chrome.driver", pathToBinary);
                    driver = new ChromeDriver(options);
                    break;
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(false);
                    chromeOptions.setAcceptInsecureCerts(true);
                    chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(5));
                    driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
                    driver.manage().window().maximize();
                    break;
                case "opera":
                    OperaOptions operaOptions = new OperaOptions();
                    operaOptions.setAcceptInsecureCerts(true);
                    operaOptions.setImplicitWaitTimeout(Duration.ofSeconds(5));
                    driver = WebDriverManager.operadriver().capabilities(operaOptions).create();
                    driver.manage().window().maximize();
                    break;
                default:
                    driver = new SafariDriver();
                    break;
            }
        }

        return driver;
    }
}