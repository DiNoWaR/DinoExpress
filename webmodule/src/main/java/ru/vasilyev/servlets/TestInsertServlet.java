package ru.vasilyev.servlets;


import ru.vasilyev.model.WagonType;
import ru.vasilyev.service.TestService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestInsertServlet extends HttpServlet {

    @EJB
    private TestService testService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<WagonType> wagonTypes = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            wagonTypes.add(new WagonType("Test", "Test", 4.0));
        }

        testService.insertCollectionOfWagonTypes(wagonTypes);

        String indexJsp = "/jsp/index.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(indexJsp);
        dispatcher.forward(request, response);

    }
}
