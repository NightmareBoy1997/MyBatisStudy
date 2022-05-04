package com.javasm.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @projectName: MyBatisStudy
 * @package: com.javasm.mybatis.utils
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-05-01 22:00
 */
public class SqlSessionUtils {

    public static SqlSession getSqlSession(){
        SqlSession sqlSession =null;

        try(InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml"); ) {
            final SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            sqlSession = build.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }

}