package ru.vasilyev.dto;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class MinRouteDTO {

    @NotNull
    private String stationFrom;
    
    @NotNull
    private String stationTo;
    
    @NotNull
    @Future
    private Date departureDate;
    
    @NotNull
    @Future
    private Date arrivalDate;
    
    @NotNull
    private int sequence;

}
