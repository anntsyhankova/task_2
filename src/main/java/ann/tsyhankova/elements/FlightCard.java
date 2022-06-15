package ann.tsyhankova.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FlightCard {

    private final WebElement element;
    private final By flightIdSelector = By.xpath(".//a[contains(@class, 'upsellpopupanchor')]");
    private final By basicPriceSelector = By.xpath(".//div[contains(@class, 'farecell1')]//span[contains(@class, 'priceBfrDec')]");
    private final By mainPriceSelector = By.xpath(".//div[contains(@class, 'farecell2')]//span[contains(@class, 'priceBfrDec')]");
    private final By comfortPriceSelector = By.xpath(".//div[contains(@class, 'farecell3')]//span[contains(@class, 'priceBfrDec')]");
    private final By firstPriceSelector = By.xpath(".//div[contains(@class, 'farecell4')]//span[contains(@class, 'priceBfrDec')]");

    public FlightCard(WebElement element) {
        this.element = element;
    }

    public String getFlightCardId(){
        return this.element.findElement(flightIdSelector).getText();
    }

    public Integer getBasicPrice(){
        if (isSoldOut(basicPriceSelector)){
            return null;
        }
        return Integer.parseInt(this.element.findElement(basicPriceSelector).getText());
    }

    public Integer getMainPrice(){
        if (isSoldOut(mainPriceSelector)){
            return null;
        }
        return Integer.parseInt(this.element.findElement(mainPriceSelector).getText());
    }

    public Integer getComfortPrice(){
        if (isSoldOut(comfortPriceSelector)){
            return null;
        }
        return Integer.parseInt(this.element.findElement(comfortPriceSelector).getText());
    }

    public Integer getFirstPrice(){
        if (isSoldOut(firstPriceSelector)){
            return null;
        }
        return Integer.parseInt(this.element.findElement(firstPriceSelector).getText());
    }

    private boolean isSoldOut(By priceSelector){
        return "Sold Out".equals(this.element.findElement(priceSelector).getText());
    }

    public int getMaxPrice(){
        return getPriceList().stream().max(Integer::compare).orElse(null);
    }

    public int getMinPrice(){
        return getPriceList().stream().max(Integer::compare).orElse(null);
    }

    private List<Integer> getPriceList(){
        List<Integer> priceList = new ArrayList<>();
        priceList.add(getBasicPrice());
        priceList.add(getMainPrice());
        priceList.add(getComfortPrice());
        priceList.add(getFirstPrice());
        priceList.remove(null);
        return priceList;
    }
}
