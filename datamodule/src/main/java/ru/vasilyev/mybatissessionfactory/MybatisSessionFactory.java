package ru.vasilyev.mybatissessionfactory;


import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

public interface MybatisSessionFactory {

    void init() throws IOException;

    SqlSessionFactory getSqlSessionFactory();

}
