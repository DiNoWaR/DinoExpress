package ru.vasilyev.model;


import lombok.Getter;

import java.io.Serializable;

@Getter
public abstract class BaseObject implements Serializable {

    private int id;
}
