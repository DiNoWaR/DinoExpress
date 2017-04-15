package ru.vasilyev.wrappers;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TrainsByStationsAndDateWrapper {

    private final String srcStation;
    private final String destStation;
    private final Date journeyDate;

}
