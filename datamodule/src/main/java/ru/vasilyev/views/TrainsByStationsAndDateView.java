package ru.vasilyev.views;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class TrainsByStationsAndDateView {

    private final String routeCode;
    private final String srcStation;
    private final String destStation;
    private final Date departureDate;
    private final Date arrivalDate;
    private final int srcSequence;
    private final int destSequence;

}
