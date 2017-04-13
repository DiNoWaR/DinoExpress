package ru.vasilyev.model;


import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
