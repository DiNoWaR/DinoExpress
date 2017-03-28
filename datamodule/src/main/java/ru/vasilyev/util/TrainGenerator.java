package ru.vasilyev.util;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import ru.vasilyev.dao.TrainDao;
import ru.vasilyev.model.Train;

@Stateless
public class TrainGenerator {

    @EJB
    private TrainDao trainDao;

    public void generateTrain(String name, String manufacturer, int maxSpeed, boolean isHighSpeed) {
        Train train = new Train(name, manufacturer, maxSpeed, isHighSpeed);
        trainDao.insertEntity(train);
    }

}
