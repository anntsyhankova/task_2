import ann.tsyhankova.factory.PageFactoryImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class deltaTest {

    @DataProvider
    public Object[][] airportsDataProvider(){
        return new Object[][]{{"NYC", "WAS"}};
    }

    @Test(dataProvider = "airportsDataProvider")
    public void flightTest(String departureAirport, String arrivalAirport){
        System.out.println(new PageFactoryImpl().getMainPage().open().findFlight(departureAirport, arrivalAirport).getCheapestTicket());
        System.out.println(new PageFactoryImpl().getMainPage().open().findFlight(departureAirport, arrivalAirport).getExpensiveTicket());
    }
}
