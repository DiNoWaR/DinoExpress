package ru.vasilyev.mappers;


import ru.vasilyev.model.Train;

public interface TrainMapper extends GenericMapper<Train> {

    int findTrainByName(String name);

}
