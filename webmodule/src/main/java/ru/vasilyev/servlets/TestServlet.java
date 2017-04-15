package ru.vasilyev.servlets;


import ru.vasilyev.model.Station;
import ru.vasilyev.views.TrainsByStationsAndDateView;
import ru.vasilyev.model.WagonType;
import ru.vasilyev.wrappers.TrainsByStationsAndDateWrapper;
import ru.vasilyev.service.TestService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestServlet extends HttpServlet {

    @Inject
    private TestService testService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();

        //
        List<WagonType> wagonTypes = testService.getAllWagonTypes();

        //
        List<Station> stations = testService.getAllStations();

        //
        Date date = convertDateFromString("2017-08-01");

        //
        TrainsByStationsAndDateWrapper wrapper = new TrainsByStationsAndDateWrapper("Nizniy Novgorod", "Saint-Petersburg", date);

        //
        List<TrainsByStationsAndDateView> trains = testService.findTrainsByStationsAndDate(wrapper);

        String greetings = "Hello Dino";

        httpSession.setAttribute("greetings", greetings);
        httpSession.setAttribute("wagonTypes", wagonTypes);
        httpSession.setAttribute("stations", stations);
        httpSession.setAttribute("trains", trains);

        String indexJsp = "/jsp/index.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(indexJsp);
        dispatcher.forward(request, response);

    }

    private Date convertDateFromString(String str) {

        Date resultDate = null;

        try {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            resultDate = format.parse(str);

        } catch (ParseException e) {
            System.out.println("Can't parse String!");
        }
        return resultDate;
    }

}
