package ann.tsyhankova.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class TripDropBox {

    private final WebElement element;
    private final By tripTypeSelector = By.xpath(".//li[contains(@class, 'select-ui-optionList')]");

    public TripDropBox(WebElement element) {
        this.element = element;
    }

    public void chooseTripTypeByTypeName(String tripTypeName) {
        getDropBoxValues()
                .stream()
                .filter(tripType -> tripTypeName.equals(tripType.getTripTypeName()))
                .findFirst()
                .orElse(null)
                .click();
    }

    private List<TripType> getDropBoxValues(){
        return this.element.findElements(tripTypeSelector).stream().map(TripType::new).collect(Collectors.toList());
    }
}
