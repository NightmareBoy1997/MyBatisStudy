package com.javasm.mybatis.test;

import com.javasm.mybatis.mapper.UserMapper;
import com.javasm.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


/**
 * @projectName: MyBatisStudy
 * @package: com.javasm
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-05-01 21:58
 */
public class MyBatisParameterTest {
    final SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    final UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    @Test
    public void myBatisParameterTest() {

//        mapper.insertUser(new User(null,"jack","abc123",22,'女',null));
//        mapper.deleteUserById(10);
//        System.out.println(mapper.queryUser(6, "tom"));
//        final int i = mapper.updateUser();
//        Map<String, Object> userMap = new HashMap<String, Object>(16);
//        userMap.put("id", 8);
//        userMap.put("name", "tom");
//        System.out.println(mapper.queryUserByMap(userMap));
//        System.out.println(mapper.queryUser(6, "tom"));
//        System.out.println(mapper.queryUserByIdToMap(4));
        System.out.println(mapper.queryAllUserToMapList());
        System.out.println(mapper.queryAllUserToMapKey());


    }


}