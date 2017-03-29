package ru.vasilyev.model;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
