package ru.vasilyev.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.vasilyev.model.Station;
import ru.vasilyev.service.TestService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class AjaxServlet extends HttpServlet {

    @EJB
    private TestService testService;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstLetter = request.getParameter("letter");

        Gson gson = new GsonBuilder().create();

        List<Station> stationsSource = testService.getAllStations();
        List<Station> stationsTarget = new ArrayList<>();

        for (Station item : stationsSource) {
            if (item.getName().startsWith(firstLetter)) {
                stationsTarget.add(item);
            }
        }

        PrintWriter out = response.getWriter();

        gson.toJson(stationsTarget, out);

        out.flush();
        out.close();

    }
}
