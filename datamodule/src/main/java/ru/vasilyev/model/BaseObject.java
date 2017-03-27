package ru.vasilyev.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class BaseObject implements Serializable {

    private int id;
}
