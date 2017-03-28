package ru.vasilyev.model;

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

    public Train() {

    }


    public Train(String name, String manufacturer, int maxSpeed, boolean isHighSpeed) {

    }

}
