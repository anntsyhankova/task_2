package ann.tsyhankova.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AirportSearchResult extends BaseElement{

    private final WebElement element;

    private final By airportCode = By.xpath("./a[@class='airportLookup-list']/span[contains(@class, 'airport-code')]");
    private final By airportCity = By.xpath("./a[@class='airportLookup-list']/span[contains(@class, 'airport-city')]");

    public AirportSearchResult(WebElement element) {
        this.element = element;
    }

    public String getAirportCode(){
        return this.element.findElement(airportCode).getText();
    }

    public String getAirportCity(){
        return this.element.findElement(airportCity).getText();
    }

    public void click(){
        this.element.click();
    }
}
