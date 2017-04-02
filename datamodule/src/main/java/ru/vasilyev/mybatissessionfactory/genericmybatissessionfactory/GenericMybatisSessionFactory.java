package ru.vasilyev.mybatissessionfactory.genericmybatissessionfactory;


import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

public interface GenericMybatisSessionFactory {

    void init() throws IOException;

    SqlSessionFactory getSqlSessionFactory();

}
