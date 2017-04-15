package ru.vasilyev.views;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class TrainsByStationsAndDateView {

    private String routeCode;
    private String srcStation;
    private String destStation;
    private Date departureDate;
    private Date arrivalDate;
    private int srcSequence;
    private int destSequence;

}
