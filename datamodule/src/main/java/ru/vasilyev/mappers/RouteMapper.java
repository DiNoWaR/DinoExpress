package ru.vasilyev.mappers;


import ru.vasilyev.model.Route;

public interface RouteMapper extends GenericMapper<Route> {

    int findRouteByRouteCode(String routeCode);

}
