package ru.vasilyev.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class TrainsResultByStationsAndDataView {

    private String routeCode;
    private String srcStation;
    private String destStation;
    private Date departureDate;
    private Date arrivalDate;
    private int srcSequence;
    private int destSequence;

}
