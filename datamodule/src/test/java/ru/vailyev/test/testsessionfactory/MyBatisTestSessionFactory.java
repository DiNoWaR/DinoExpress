package ru.vailyev.test.testsessionfactory;

import lombok.Getter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.io.IOException;
import java.io.Reader;

@Singleton
@Getter
public class MyBatisTestSessionFactory {

    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void init() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatistestconfig/mybatis-test-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }
}
