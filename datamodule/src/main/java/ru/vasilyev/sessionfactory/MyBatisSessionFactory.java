package ru.vasilyev.sessionfactory;

import lombok.Getter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.IOException;
import java.io.Reader;

@Singleton
@Startup
@Getter
public class MyBatisSessionFactory {

    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void init() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatisconfig/mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }
}
