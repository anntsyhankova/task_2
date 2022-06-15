import ann.tsyhankova.factory.PageFactoryImpl;
import org.testng.annotations.Test;

public class deltaTest {

    @Test
    public void flightTest(){
        new PageFactoryImpl().getMainPage().open().findFlight().getCheapestTicket();

        System.out.println(new PageFactoryImpl().getMainPage().open().findFlight().getExpensiveTicket());
    }
}
