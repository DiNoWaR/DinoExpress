package ru.vasilyev.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Seat extends BaseObject {

    private int number;
    private boolean nearTable;
    private boolean isVacant;
    private Wagon wagon;

}
