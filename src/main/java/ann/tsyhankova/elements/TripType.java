package ann.tsyhankova.elements;

import org.openqa.selenium.WebElement;

public class TripType {

    private WebElement element;

    public TripType(WebElement element) {
        this.element = element;
    }

    public String getTripTypeName(){
        return element.getText();
    }

    public void click(){
        element.click();
    }
}
