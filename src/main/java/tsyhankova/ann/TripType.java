package tsyhankova.ann;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TripType {
    ROUND_TRIP("Round Trip"),
    ONE_WAY("One Way"),
    MULTI_CITY("Multi-City");
    private final String value;
}
