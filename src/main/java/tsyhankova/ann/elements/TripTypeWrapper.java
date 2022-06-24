package tsyhankova.ann.elements;

import org.openqa.selenium.WebElement;

public class TripTypeWrapper {

    private final WebElement element;

    public TripTypeWrapper(WebElement element) {
        this.element = element;
    }

    public String getTripTypeName(){
        return element.getText();
    }

    public void click(){
        element.click();
    }
}
