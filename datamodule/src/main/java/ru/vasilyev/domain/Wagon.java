package ru.vasilyev.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Wagon extends BaseObject {

    private int wagonNumber;
    private WagonType wagonType;
    private Train train;

}
