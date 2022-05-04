package com.javasm.mybatis.util;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @projectName: MyBatisStudy
 * @package: com.javasm.mybatis.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-05-03 10:28
 */
public class SqlSessionUtil {

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        try( InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml"); )
        {
            sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }

}