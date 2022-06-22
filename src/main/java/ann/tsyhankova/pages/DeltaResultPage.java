package ann.tsyhankova.pages;

import ann.tsyhankova.elements.FlightCard;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DeltaResultPage implements ResultPage{

    private final By flightCardListSelector = By.xpath("//div[contains(@class,'flightcardContainer')]");
    @Override
    public List<FlightCard> getFlightCardList(){
        return driver.findElements(flightCardListSelector)
                .stream()
                .map(FlightCard::new)
                .collect(Collectors.toList());
    }

    @Override
    public ResultPage open() {
        return null;
    }

    @Override
    public ResultPage render() {
        wait.until(ExpectedConditions.presenceOfElementLocated(flightCardListSelector));
        return this;
    }
}
