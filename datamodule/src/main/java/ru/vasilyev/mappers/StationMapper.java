package ru.vasilyev.mappers;


import ru.vasilyev.mappers.genericmapper.GenericMapper;
import ru.vasilyev.model.Station;

public interface StationMapper extends GenericMapper<Station> {

    int findStationIdByName(String name);

}
