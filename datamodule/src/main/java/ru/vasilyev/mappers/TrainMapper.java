package ru.vasilyev.mappers;


import ru.vasilyev.mappers.genericmapper.GenericMapper;
import ru.vasilyev.model.Train;

public interface TrainMapper extends GenericMapper<Train> {

    int findTrainIdByName(String name);

}
