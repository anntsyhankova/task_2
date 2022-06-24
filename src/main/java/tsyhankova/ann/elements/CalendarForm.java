package tsyhankova.ann.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CalendarForm {

    private final WebElement element;
    private final By doneButton = By.xpath(".//button[@class='donebutton']");


    public CalendarForm(WebElement element) {
        this.element = element;
    }

    public CalendarForm setDepartureTripDate(String departureTripDate){
        this.element.findElement(buildSelectorFromDate(departureTripDate)).click();
        return this;
    }

    public CalendarForm setArrivalTripDate(String arrivalTripDate){
        this.element.findElement(buildSelectorFromDate(arrivalTripDate)).click();
        return this;
    }

    public void clickSubmitDatesButton(){
        this.element.findElement(doneButton).click();
    }

    private By buildSelectorFromDate(String date){
        return By.xpath(".//a[contains(@data-date, '" + date + "')]");
    }
}
