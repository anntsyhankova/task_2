package ann.tsyhankova.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class CalendarForm {

    private final WebElement element;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private final String departureTripDate = dateTimeFormatter.format(LocalDate.now().plus(1, ChronoUnit.WEEKS));
    private final String arrivalTripDate = dateTimeFormatter.format(LocalDate.now().plus(2, ChronoUnit.WEEKS));
    private final By doneButton = By.xpath(".//button[@class='donebutton']");


    public CalendarForm(WebElement element) {
        this.element = element;
    }

    public void setTripDates(){
        this.element.findElement(requiredDate(departureTripDate)).click();
        this.element.findElement(requiredDate(arrivalTripDate)).click();
        this.element.findElement(doneButton).click();
    }

    private By requiredDate(String date){
        StringBuilder selector = new StringBuilder(".//a[contains(@data-date, '')]");
        selector.insert(27, date);
        return By.xpath(selector.toString());
    }
}
