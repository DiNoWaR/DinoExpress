package ru.vasilyev.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class WagonType extends BaseObject {

    @NotNull
    private String classCode;

    @NotNull
    private String description;

    @NotNull
    private double classCoefficient;

}
