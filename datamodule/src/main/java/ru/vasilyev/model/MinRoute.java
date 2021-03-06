package ru.vasilyev.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MinRoute extends BaseObject {

    private int stationFrom;
    private int stationTo;
    private Date departureDate;
    private Date arrivalDate;
    private int train;
    private int route;
    private int sequence;

}
