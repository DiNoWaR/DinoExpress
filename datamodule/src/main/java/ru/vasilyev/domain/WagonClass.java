package ru.vasilyev.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class WagonClass extends BaseObject {

    private String classCode;
    private String Description;
    private double classCoefficient;

}
