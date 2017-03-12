package ru.vasilyev.servlets;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ru.vasilyev.domain.WagonType;
import ru.vasilyev.mappers.WagonTypeMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Reader;

public class TestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Reader reader = Resources.getResourceAsReader("config/mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        WagonTypeMapper wagonTypeMapper = session.getMapper(WagonTypeMapper.class);

        WagonType wagonType = new WagonType();
        wagonType.setClassCode("2c");
        wagonType.setDescription("Nischebrody");
        wagonType.setClassCoefficient(1.1);

        wagonTypeMapper.insertEntity(wagonType);

        session.commit();

        HttpSession httpSession = request.getSession();
        String greetings = "Hello Dino";

        httpSession.setAttribute("greetings", greetings);
        String indexJsp = "/jsp/index.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(indexJsp);
        dispatcher.forward(request, response);

    }
}
