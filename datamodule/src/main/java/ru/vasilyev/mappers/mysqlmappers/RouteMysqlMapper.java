package ru.vasilyev.mappers.mysqlmappers;


import ru.vasilyev.mappers.genericmapper.GenericMapper;
import ru.vasilyev.model.Route;

public interface RouteMysqlMapper extends GenericMapper<Route> {

    int findRouteIDByRouteCode(String routeCode);

}
