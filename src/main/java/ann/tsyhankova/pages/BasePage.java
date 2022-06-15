package ann.tsyhankova.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ann.tsyhankova.factory.DriverFactory;

import java.time.Duration;

public interface BasePage<T extends BasePage> {

    WebDriver driver = DriverFactory.getInstance();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    T open();

    T render();
}