package ru.vasilyev.servlets;


import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.domain.WagonType;
import ru.vasilyev.ejb.MyBatisSessionFactory;
import ru.vasilyev.mappers.WagonTypeMapper;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TestServlet extends HttpServlet {

    @EJB
    private MyBatisSessionFactory myBatisSessionFactory;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        SqlSession session = myBatisSessionFactory.getSqlSessionFactory().openSession();

        WagonTypeMapper wagonTypeMapper = session.getMapper(WagonTypeMapper.class);

        WagonType wagonType = new WagonType();
        wagonType.setClassCode("2c");
        wagonType.setDescription("Nischebrody");
        wagonType.setClassCoefficient(1.1);

        wagonTypeMapper.insertEntity(wagonType);

        HttpSession httpSession = request.getSession();
        String greetings = "Hello Dino";

        httpSession.setAttribute("greetings", greetings);
        String indexJsp = "/jsp/index.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(indexJsp);
        dispatcher.forward(request, response);

    }
}
