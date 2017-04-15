package ru.vasilyev.mybatissessionfactory;

import lombok.Getter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;
import java.io.IOException;
import java.io.Reader;

@Named("myBatisMysqlSessionFactory")
@Singleton
@Getter
public class MyBatisMysqlSessionFactory implements MybatisSessionFactory {

    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void init() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatisconfig/mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }
}
