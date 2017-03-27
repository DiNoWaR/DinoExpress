package ru.vasilyev.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Station extends BaseObject {

    private String name;
    private double latitude;
    private double longitude;

}
