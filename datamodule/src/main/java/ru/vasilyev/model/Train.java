package ru.vasilyev.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Train extends BaseObject {

    private final String name;
    private final String manufacturer;
    private final int maxSpeed;
    private final boolean isHighSpeed;
    private final List<MinRoute> minRoutes;
    private final List<Wagon> wagons;


}
