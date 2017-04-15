package ru.vasilyev.mappers.mysqlmappers;


import ru.vasilyev.mappers.genericmapper.GenericMapper;
import ru.vasilyev.model.Train;
import ru.vasilyev.views.RoutesByStationsAndDateView;
import ru.vasilyev.wrappers.RoutesByStationsAndDateWrapper;

import java.util.List;

public interface TrainMysqlMapper extends GenericMapper<Train> {

    int findTrainByName(String name);

}
