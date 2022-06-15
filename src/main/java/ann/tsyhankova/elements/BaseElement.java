package ann.tsyhankova.elements;

import ann.tsyhankova.factory.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseElement {

    protected WebDriver driver;

    public BaseElement(){

        this.driver = DriverFactory.getInstance();
    }
}