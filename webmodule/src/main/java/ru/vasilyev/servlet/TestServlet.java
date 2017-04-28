package ru.vasilyev.servlet;


import ru.vasilyev.enums.JSPPath;
import ru.vasilyev.model.Station;
import ru.vasilyev.service.DateTimeConverter;
import ru.vasilyev.views.RoutesByStationsAndDateView;
import ru.vasilyev.model.WagonType;
import ru.vasilyev.wrappers.RoutesByStationsAndDateWrapper;
import ru.vasilyev.service.TestService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestServlet extends HttpServlet {

    @Inject
    private TestService testService;

    @Inject
    private DateTimeConverter converter;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //
        List<WagonType> wagonTypes = testService.getAllWagonTypes();

        //
        List<Station> stations = testService.getAllStations();

        //
        Date date = converter.convertStringToDate("2017-08-01", "yyyy-MM-dd");

        //
        RoutesByStationsAndDateWrapper wrapper = new RoutesByStationsAndDateWrapper("Nizniy Novgorod", "Saint-Petersburg", date);

        //
        List<RoutesByStationsAndDateView> routes = testService.findTrainsByStationsAndDate(wrapper);

        String greetings = "Hello Dino";

        request.setAttribute("greetings", greetings);
        request.setAttribute("wagonTypes", wagonTypes);
        request.setAttribute("stations", stations);
        request.setAttribute("routes", routes);

        String indexJsp = JSPPath.INDEX_JSP.getValue();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(indexJsp);
        dispatcher.forward(request, response);

    }

}
