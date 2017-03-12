package ru.vasilyev.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Train extends BaseObject {

    private String name;
    private String manufacturer;
    private int maxSpeed;
    private boolean isHighSpeed;
    private List<MinRoute> minRoutes;
    private List<Wagon> wagons;
}
