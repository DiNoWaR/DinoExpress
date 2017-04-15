package ru.vasilyev.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Wagon extends BaseObject {

    private final int wagonNumber;
    private final WagonType wagonType;
    private final Train train;

}
