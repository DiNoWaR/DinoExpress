package ru.vasilyev.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MinRoute extends BaseObject {

    private Station stationFrom;

}
