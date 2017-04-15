package ru.vasilyev.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MinRoute extends BaseObject {

    private final int stationFrom;
    private final int stationTo;
    private final Date departureDate;
    private final Date arrivalDate;
    private final int train;
    private final int route;
    private final int sequence;

}
