package com.webdiapp.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class MyBatisUtil {
    
    public static SqlSessionFactory getSqlSessionFactory(){
        InputStream config = MyBatisUtil.class.getClassLoader().getResourceAsStream("MyBatisCfg.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
        System.out.println("factory:" + factory.openSession(true));
        return factory;
    }

    public static SqlSession getSession(){
        return getSqlSessionFactory().openSession(true);
    }
    
    public static SqlSession getSession(boolean isAutoCommit){
        return getSqlSessionFactory().openSession(isAutoCommit);
    }

}