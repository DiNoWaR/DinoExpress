package ru.vasilyev.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class WagonType extends BaseObject {

    private final String classCode;
    private final String description;
    private final double wagonTypeCoefficient;

}
