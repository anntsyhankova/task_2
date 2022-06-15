package ann.tsyhankova.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class AirportSearchBox {

    private final WebElement element;

    private final By airportSearchInput = By.xpath(".//input[contains(@class, 'airport-search')]");
    private final By airportSearchResultList = By.xpath(".//tab[@id='airport-serach-tab']//li[contains(@class, 'airport-list')]");

    public void findAirportByName(String airportCode){

        setAirportSearchInput(airportCode);
        getAirportSearchResultList()
                .stream()
                .filter(airportSearchResult -> airportCode.equals(airportSearchResult.getAirportCode()))
                .findFirst()
                .orElse(null)
                .click();
    }

    private void setAirportSearchInput(String airportCode){
        this.element.findElement(airportSearchInput).sendKeys(airportCode);

    }

    private List<AirportSearchResult> getAirportSearchResultList(){
        return this.element.findElements(airportSearchResultList).stream().map(AirportSearchResult::new).collect(Collectors.toList());
    }

    public AirportSearchBox(WebElement element) {
        this.element = element;
    }
}
