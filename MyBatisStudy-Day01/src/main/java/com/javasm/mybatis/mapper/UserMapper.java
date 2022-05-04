package com.javasm.mybatis.mapper;

import com.javasm.mybatis.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @projectName: MyBatisStudy
 * @package: com.javasm.mybatis.mapper
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-05-01 21:37
 */
public interface UserMapper {
    int insertUser(User user);
    int updateUser();
    int deleteUserById(Integer id);

    User queryUser(Integer id,String name);
    List<User> queryAllUserById(Map<String,Object> userMap);
    User queryUserByMap(Map<String,Object> userMap);
    User queryUserByParam(@Param("paramId") Integer id,@Param("paramName") String name);

    Map<String,Object> queryUserByIdToMap(@Param("id")Integer id);
    List<Map<String,Object>> queryAllUserToMapList();
    @MapKey("id")
    Map<String,Map<String,Object>> queryAllUserToMapKey();

}
