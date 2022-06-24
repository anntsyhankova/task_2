import tsyhankova.ann.TripType;
import tsyhankova.ann.elements.FlightCard;
import tsyhankova.ann.factory.PageFactoryImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

public class DeltaTest {

    @DataProvider
    public Object[][] airportsDataProvider() {
        return new Object[][]{
                {
                        "NYC", "WAS", TripType.ROUND_TRIP,
                        DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now().plus(1, ChronoUnit.WEEKS)),
                        DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now().plus(2, ChronoUnit.WEEKS))
                }
        };
    }

    @Test(dataProvider = "airportsDataProvider")
    public void minPriceFlightTest(String departureAirport, String arrivalAirport, TripType tripType, String tripDepartureDate, String tripArrivalDate) {
        List<FlightCard> flightCardList = new PageFactoryImpl()
                .getMainPage().open()
                .findFlight(
                        departureAirport,
                        arrivalAirport,
                        tripType,
                        tripDepartureDate,
                        tripArrivalDate)
                .getFlightCardList();
        System.out.println(flightCardList.stream().max(Comparator.comparingInt(FlightCard::getMaxPrice)).orElse(null).getFlightCardId());
    }

    @Test(dataProvider = "airportsDataProvider")
    public void maxPriceFlightTest(String departureAirport, String arrivalAirport, TripType tripType, String tripDepartureDate, String tripArrivalDate) {
        List<FlightCard> flightCardList = new PageFactoryImpl()
                .getMainPage().open()
                .findFlight(
                        departureAirport,
                        arrivalAirport,
                        tripType,
                        tripDepartureDate,
                        tripArrivalDate)
                .getFlightCardList();
        System.out.println(flightCardList.stream().max(Comparator.comparingInt(FlightCard::getMaxPrice)).orElse(null).getFlightCardId());
    }
}
