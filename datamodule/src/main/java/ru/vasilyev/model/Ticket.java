package ru.vasilyev.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Ticket extends BaseObject {

    private final int user;
    private final double price;

}
