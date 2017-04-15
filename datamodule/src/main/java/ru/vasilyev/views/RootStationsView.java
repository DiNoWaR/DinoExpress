package ru.vasilyev.views;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RootStationsView {

    private String srcStation;
    private String destStation;
    private Date departureDate;
    private Date arrivalDate;

}
