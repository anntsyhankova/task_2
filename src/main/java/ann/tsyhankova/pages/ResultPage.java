package ann.tsyhankova.pages;

import ann.tsyhankova.elements.FlightCard;

import java.util.List;

public interface ResultPage extends BasePage<ResultPage>{
    List<FlightCard> getFlightCardList();
}
