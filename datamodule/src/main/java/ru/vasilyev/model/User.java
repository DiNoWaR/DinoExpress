package ru.vasilyev.model;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.vasilyev.enums.Gender;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends BaseObject {

    private String name;
    private String lastName;
    private Date birthDate;
    private String email;
    private String password;
    private Gender gender;
    private boolean isAdmin;
    private int passportData;
}
