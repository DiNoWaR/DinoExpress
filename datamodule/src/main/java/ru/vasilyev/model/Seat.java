package ru.vasilyev.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Seat extends BaseObject {

    private final int number;
    private final boolean nearTable;
    private final boolean isVacant;
    private final Wagon wagon;

}
