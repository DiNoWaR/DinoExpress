package ru.vasilyev.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Route extends BaseObject {

    private final String routeCode;
    private final boolean assigned;

}
