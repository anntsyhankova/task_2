package ann.tsyhankova.pages;

public interface MainPage extends BasePage<MainPage>{

    ResultPage findFlight(String departureAirport, String arrivalAirport);
}
