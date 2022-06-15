package ann.tsyhankova.pages;

import ann.tsyhankova.elements.AirportSearchBox;
import ann.tsyhankova.elements.CalendarForm;
import ann.tsyhankova.elements.TripDropBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeltaMainPage implements MainPage {

    private final By cookiesButton = By.xpath("//button[contains(@class, 'gdpr-banner-accept-btn')]");
    private final By departureCityButton = By.id("fromAirportName");
    private final By arrivalCityButton = By.id("toAirportName");
    private final By tripTypeDropBox = By.xpath("//div[contains(@class, 'trip-type-container')]");
    private final By calenderButton = By.xpath("//date-selection-view");
    private final By searchDialog = By.xpath("//div[contains(@class, 'search-dialog')]");
    private final By submitButton = By.xpath("//button[@id='btn-book-submit']");

    public ResultPage findFlight() {
        openSearchDialog(driver.findElement(departureCityButton)).findAirportByName("WAS");
        openSearchDialog(driver.findElement(arrivalCityButton)).findAirportByName("NYC");
        openTripDropbox().chooseTripTypeByTypeName("Round Trip");
        openCalendarForm().setTripDates();
        driver.findElement(submitButton).click();
        return new DeltaResultPage();
    }

    public AirportSearchBox openSearchDialog(WebElement button) {
        button.click();
        return new AirportSearchBox(driver.findElement(searchDialog));
    }

    public CalendarForm openCalendarForm() {
        WebElement calendar = driver.findElement(calenderButton);
        calendar.click();
        return new CalendarForm(calendar);
    }

    public TripDropBox openTripDropbox() {
        WebElement dropbox = driver.findElement(tripTypeDropBox);
        dropbox.click();
        return new TripDropBox(dropbox);
    }

    @Override
    public DeltaMainPage open() {
        driver.get("https://www.delta.com/");
        checkForCookies();
        return this;
    }

    @Override
    public DeltaMainPage render() {
        wait.until(ExpectedConditions.presenceOfElementLocated(cookiesButton));
        return this;
    }

    public void checkForCookies(){
        if (driver.findElements(cookiesButton).size() != 0){
            driver.findElement(cookiesButton).click();
        }
    }
}
