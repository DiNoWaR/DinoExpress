package ru.vasilyev.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Train extends BaseObject {

    private String name;
    private String manufacturer;
    private int maxSpeed;
    private boolean isHighSpeed;
    private List<MinRoute> minRoutes;
    private List<Wagon> wagons;


}
