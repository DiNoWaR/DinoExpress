package ru.vasilyev.mappers.mysqlmappers;


import ru.vasilyev.mappers.genericmapper.GenericMapper;
import ru.vasilyev.model.Train;
import ru.vasilyev.views.TrainsByStationsAndDateView;
import ru.vasilyev.wrappers.TrainsByStationsAndDateWrapper;

import java.util.List;

public interface TrainMysqlMapper extends GenericMapper<Train> {

    int findTrainByName(String name);

    List<TrainsByStationsAndDateView> findTrainsByStationsAndDate(TrainsByStationsAndDateWrapper wrapper);

}
