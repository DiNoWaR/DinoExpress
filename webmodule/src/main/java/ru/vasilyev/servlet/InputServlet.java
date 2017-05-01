package ru.vasilyev.servlet;

import ru.vasilyev.enums.JSPPath;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class InputServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String indexJsp = JSPPath.INPUT_FIELD_JSP.getValue();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(indexJsp);
        dispatcher.forward(request, response);

    }
}
