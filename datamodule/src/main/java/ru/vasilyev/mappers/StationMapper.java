package ru.vasilyev.mappers;


import ru.vasilyev.mappers.genericmapper.GenericMapper;
import ru.vasilyev.model.Station;

import java.util.List;

public interface StationMapper extends GenericMapper<Station> {

    int findStationIdByName(String name);

    List<Station> getStationsByNamePattern(String pattern);
}
