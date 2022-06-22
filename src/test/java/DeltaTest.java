import ann.tsyhankova.elements.FlightCard;
import ann.tsyhankova.factory.PageFactoryImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class DeltaTest {

    @DataProvider
    public Object[][] airportsDataProvider(){
        return new Object[][]{{"NYC", "WAS"}};
    }

    @Test(dataProvider = "airportsDataProvider")
    public void minPriceFlightTest(String departureAirport, String arrivalAirport){
        List<FlightCard> flightCardList = new PageFactoryImpl().getMainPage().open().findFlight(departureAirport, arrivalAirport).getFlightCardList();
        System.out.println(flightCardList.stream().max(Comparator.comparingInt(FlightCard::getMaxPrice)).orElse(null).getFlightCardId());
    }

    @Test(dataProvider = "airportsDataProvider")
    public void maxPriceFlightTest(String departureAirport, String arrivalAirport){
        List<FlightCard> flightCardList = new PageFactoryImpl().getMainPage().open().findFlight(departureAirport, arrivalAirport).getFlightCardList();
        System.out.println(flightCardList.stream().max(Comparator.comparingInt(FlightCard::getMaxPrice)).orElse(null).getFlightCardId());
    }
}
