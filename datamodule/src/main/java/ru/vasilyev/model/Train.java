package ru.vasilyev.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Train extends BaseObject {

    private String name;
    private String manufacturer;
    private int maxSpeed;
    private boolean isHighSpeed;
    private List<MinRoute> minRoutes;
    private List<Wagon> wagons;


}
