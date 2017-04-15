package ru.vasilyev.model;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import ru.vasilyev.enums.Gender;

import java.util.Date;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends BaseObject {

    private final String name;
    private final String lastName;
    private final Date birthDate;
    private final String email;
    private final String password;
    private final Gender gender;
    private final boolean isAdmin;
    private final int passportData;
}
