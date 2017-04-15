package ru.vasilyev.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Station extends BaseObject {

    private final String name;
    private final double latitude;
    private final double longitude;

}
