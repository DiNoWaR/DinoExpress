package ru.vasilyev.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class WagonType extends BaseObject {

    private String classCode;
    private String description;
    private double classCoefficient;

}
