package tsyhankova.ann.pages;

import tsyhankova.ann.elements.FlightCard;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class DeltaResultPage implements BasePage<DeltaResultPage>{

    private final By flightCardListSelector = By.xpath("//div[contains(@class,'flightcardContainer')]");

    public List<FlightCard> getFlightCardList(){
        return driver.findElements(flightCardListSelector)
                .stream()
                .map(FlightCard::new)
                .collect(Collectors.toList());
    }

    @Override
    public DeltaResultPage open() {
        return null;
    }

    @Override
    public DeltaResultPage render() {
        wait.until(ExpectedConditions.presenceOfElementLocated(flightCardListSelector));
        return this;
    }
}
