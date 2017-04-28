package ru.vasilyev.servlet;


import ru.vasilyev.enums.JSPPath;
import ru.vasilyev.model.Station;
import ru.vasilyev.service.TestService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AjaxServlet extends HttpServlet {

    @Inject
    private TestService testService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pattern = request.getParameter("stationName");
        List<Station> stations = testService.getStationsByNamePattern(pattern);

        request.setAttribute("stations",stations);
        String indexJsp = JSPPath.INPUT_FIELD_JSP.getValue();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(indexJsp);
        dispatcher.forward(request, response);
    }
}
