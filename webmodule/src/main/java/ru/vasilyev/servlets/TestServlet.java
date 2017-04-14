package ru.vasilyev.servlets;


import ru.vasilyev.model.Station;
import ru.vasilyev.model.WagonType;
import ru.vasilyev.service.TestService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TestServlet extends HttpServlet {

    @Inject
    private TestService testService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();

        List<WagonType> wagonTypes = testService.getAllWagonTypes();
        List<Station> stations = testService.getAllStations();

        String greetings = "Hello Dino";

        httpSession.setAttribute("greetings", greetings);
        httpSession.setAttribute("wagonTypes", wagonTypes);
        httpSession.setAttribute("stations", stations);

        String indexJsp = "/jsp/index.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(indexJsp);
        dispatcher.forward(request, response);

    }
}
