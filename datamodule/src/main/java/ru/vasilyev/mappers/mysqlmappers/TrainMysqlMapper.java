package ru.vasilyev.mappers.mysqlmappers;


import ru.vasilyev.mappers.genericmapper.GenericMapper;
import ru.vasilyev.model.Train;
import ru.vasilyev.model.TrainsResultByStationsAndDataView;

import java.util.List;

public interface TrainMysqlMapper extends GenericMapper<Train> {

    int findTrainByName(String name);

    List<TrainsResultByStationsAndDataView> findTrainsByStationsAndData();

}
