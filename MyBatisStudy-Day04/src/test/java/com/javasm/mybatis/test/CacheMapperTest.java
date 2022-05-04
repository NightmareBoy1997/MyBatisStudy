package com.javasm.mybatis.test;

import com.javasm.mybatis.entity.Employee;
import com.javasm.mybatis.mapper.CacheMapper;
import com.javasm.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @projectName: MyBatisStudy
 * @package: com.javasm.mybatis.test
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-05-03 23:46
 */
public class CacheMapperTest {

    @Test
    public void getEmployeeById() {
        final SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        final CacheMapper mapper1 = sqlSession.getMapper(CacheMapper.class);
            final Employee employeeById = mapper1.getEmployeeById(4);
            System.out.println(employeeById);

            // 手动清空一级缓存
//            sqlSession.clearCache();

            final CacheMapper mapper2 = sqlSession.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmployeeById(4));
    }

    /**
     * 测试二级缓存
     */
    @Test
    public void getEmployeeById2() {
        try (final InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        ) {
            final SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            final SqlSession sqlSession1 = build.openSession(true);
            final CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            final Employee employeeById = mapper1.getEmployeeById(4);
            System.out.println(employeeById);

            // 手动提交 sqlSession
            sqlSession1.commit();
            // 手动关闭 sqlSession
//            sqlSession1.close();

            final SqlSession sqlSession2 = build.openSession(true);
            final CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmployeeById(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}