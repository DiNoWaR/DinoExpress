package ru.vasilyev.mappers.mysqlmappers;


import ru.vasilyev.mappers.genericmapper.GenericMapper;
import ru.vasilyev.model.Train;

public interface TrainMysqlMapper extends GenericMapper<Train> {

    int findTrainIdByName(String name);

}
