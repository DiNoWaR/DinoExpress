package ru.vasilyev.mappers.mysqlmappers;


import ru.vasilyev.mappers.genericmapper.GenericMapper;
import ru.vasilyev.model.Route;
import ru.vasilyev.views.RootStationsView;
import ru.vasilyev.views.RoutesByStationsAndDateView;
import ru.vasilyev.wrappers.RoutesByStationsAndDateWrapper;

import java.util.List;

public interface RouteMysqlMapper extends GenericMapper<Route> {

    int findRouteIDByRouteCode(String routeCode);

    List<RootStationsView> findStationsWhichRoutePasses(String routeCode);

    List<RoutesByStationsAndDateView> findRoutesByStationsAndDate(RoutesByStationsAndDateWrapper wrapper);
}
