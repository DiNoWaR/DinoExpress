package ru.vasilyev.mappers.mysqlmappers;


import ru.vasilyev.mappers.genericmapper.GenericMapper;
import ru.vasilyev.model.Station;

public interface StationMysqlMapper extends GenericMapper<Station> {

    int findStationIdByName(String name);

}
