package ru.vasilyev.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class WagonType extends BaseObject {

    private String classCode;
    private String description;
    private double wagonTypeCoefficient;

}
