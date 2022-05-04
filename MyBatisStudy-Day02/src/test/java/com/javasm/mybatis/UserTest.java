package com.javasm.mybatis;

import com.javasm.mybatis.entity.User;
import com.javasm.mybatis.mapper.UserMapper;
import com.javasm.mybatis.utils.SqlSessionUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.*;
import java.util.List;

/**
 * @projectName: MyBatisStudy
 * @package: com.javasm.mybatis
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-05-02 10:59
 */
public class UserTest {
    final UserMapper mapper = SqlSessionUtils.getSqlSession().getMapper(UserMapper.class);

    /**
     * MyBatis的各种查询功能：
     * 1、若查询出的数据只有一条
     * a>可以通过实体类对象接收
     * b>可以通过list集合接收
     * c>可以通过map集合接收
     * 结果：{password=123456, sex=男, id=3, age=23, email=12345@qq.com, username=admin}
     * 2、若查询出的数据有多条
     * a>可以通过实体类类型的list集合接收
     * b>可以通过map类型的list集合接收
     * c>可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换的map集合作为值，以某个字段的值作为键，放在同一个map集合中
     * 注意：一定不能通过实体类对象接收，此时会抛异常TooManyResultsException
     *
     * MyBatis中设置了默认的类型别名
     * java.lang.Integer-->int,integer
     * int-->_int,_integer
     * Map-->map
     * String-->string
     */
    /**
     * MyBatis的各种查询功能：
     * 1、若查询出的数据只有一条
     * a>可以通过实体类对象接收
     * b>可以通过list集合接收
     * c>可以通过map集合接收
     * 结果：{password=123456, sex=男, id=3, age=23, email=12345@qq.com, username=admin}
     * 2、若查询出的数据有多条
     * a>可以通过实体类类型的list集合接收
     * b>可以通过map类型的list集合接收
     * c>可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换的map集合作为值，以某个字段的值作为键，放在同一个map集合中
     * 注意：一定不能通过实体类对象接收，此时会抛异常TooManyResultsException
     *
     * MyBatis中设置了默认的类型别名
     * java.lang.Integer-->int,integer
     * int-->_int,_integer
     * Map-->map
     * String-->string
     */

    @Test
    public void userLikeSelect() throws IOException {
        final List<User> userLike = mapper.findUserLike("to");
        System.out.println(userLike);
        final List<User> userLike2 = mapper.findUserlike2("to");
        System.out.println(userLike2);
    }

    @Test
    public void userDelete(){
        System.out.println(mapper.deleteUser("8,9,10"));
    }

    @Test
    public void tableNameInsert(){
        final Integer tb_users = mapper.selectByTableName("tb_users");
    }

    @Test
    public void insertUserFindAutoId(){
        User user = new User(null,"康康","tom123",44,"男","tom@qq.com");
        System.out.println(mapper.insertUserFindAutoId(user));
        System.out.println(user);
    }


/*    //获取自增主键
    @Test
    public void testJDBC() throws Exception {
        Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
        PreparedStatement ps = connection.prepareStatement("insert", Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        ResultSet resultSet = ps.getGeneratedKeys();
    }*/

}