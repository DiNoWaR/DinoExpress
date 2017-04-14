package ru.vasilyev.mybatissessionfactory;


import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

public interface GenericMybatisSessionFactory {

    void init() throws IOException;

    SqlSessionFactory getSqlSessionFactory();

}
