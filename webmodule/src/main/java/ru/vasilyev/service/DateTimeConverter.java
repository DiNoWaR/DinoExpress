package ru.vasilyev.service;


import javax.ejb.Stateful;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Stateful
public class DateTimeConverter {


    public Date convertStringToDate(String str, String pattern) {

        Date resultDate = null;

        try {

            SimpleDateFormat format = new SimpleDateFormat(pattern);
            resultDate = format.parse(str);

        } catch (ParseException e) {
            System.out.println("Can't parse String!");
        }
        return resultDate;
    }


}
