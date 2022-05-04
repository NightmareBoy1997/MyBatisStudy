package com.javasm.mybatis.mapper;

import com.javasm.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @projectName: MyBatisStudy
 * @package: com.javasm.mybatis
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-05-02 10:55
 */
public interface UserMapper {

    /**
     * 根据用户名模糊查询用户信息
     */
    List<User> findUserLike(@Param("likename")String likename);

    /**
     * 根据用户名模糊查询用户信息
     */
    List<User> findUserlike2(@Param("likename")String likename);

    /**
     * 批量删除
     */
    Integer deleteUser(@Param("id")String id);

    /**
     * 查询指定表中的数据
     */
    Integer selectByTableName(@Param("tableName")String tableName);

    /**
     * 添加用户信息
     */
    Integer insertUserFindAutoId(User user);

}