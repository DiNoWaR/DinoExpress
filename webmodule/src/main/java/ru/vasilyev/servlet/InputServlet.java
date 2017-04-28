package ru.vasilyev.servlet;


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

public class InputServlet extends HttpServlet {

    @Inject
    private TestService testService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Station> stations = testService.getStationsByNamePattern("iy");

        request.setAttribute("stations", stations);

        String indexJsp = "/jsp/inputfield.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(indexJsp);
        dispatcher.forward(request, response);
    }
}
