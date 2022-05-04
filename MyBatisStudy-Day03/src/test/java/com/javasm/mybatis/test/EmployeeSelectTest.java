package com.javasm.mybatis.test;

import com.javasm.mybatis.entity.Employee;
import com.javasm.mybatis.mapper.EmployeeMapper;
import com.javasm.mybatis.util.SqlSessionUtils;
import org.junit.Test;

import java.util.List;

/**
 * @projectName: MyBatisStudy
 * @package: com.javasm.mybatis.test
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-05-02 21:39
 */
public class EmployeeSelectTest {
    EmployeeMapper empMapper = SqlSessionUtils.getSqlSession().getMapper(EmployeeMapper.class);

    /**
     * 解决字段名和属性名不一致的情况：
     * a>为字段起别名，保持和属性名的一致
     * b>设置全局配置，将_自动映射为驼峰
     * <setting name="mapUnderscoreToCamelCase" value="true"/>
     * c>通过resultMap设置自定义的映射关系
     * <resultMap id="empResultMap" type="Emp">
     *     <id property="eid" column="eid"></id>
     *     <result property="empName" column="emp_name"></result>
     *     <result property="age" column="age"></result>
     *     <result property="sex" column="sex"></result>
     *     <result property="email" column="email"></result>
     * </resultMap>
     *
     * 处理多对一的映射关系：
     * a>级联属性赋值
     * b>association
     * c>分步查询
     *
     * 处理一对多的映射关系
     * a>collection
     * b>分步查询
     */


    @Test
    public void getEmpByIdWithLabel(){
        final Employee empByIdLabel = empMapper.getEmpByIdWithLabel(6);
        System.out.println(empByIdLabel);
    }

    @Test
    public void getEmpByIdWithResultMap(){
        final Employee empById = empMapper.getEmpByIdWithResultMap(3);
        System.out.println(empById);
    }


    @Test
    public void getEmpWithTier(){
        final Employee empWithTier = empMapper.getEmpWithTier(3);
        System.out.println(empWithTier);
    }
    @Test
    public void getEmpWithAssociation(){
        final Employee empWithAssociation = empMapper.getEmpWithAssociation(7);
        System.out.println(empWithAssociation);
    }


    @Test
    public void getEmpAndDeptStep(){
        final Employee empAndDeptStepOne = empMapper.getEmpAndDeptStepOne(5);
        System.out.println(empAndDeptStepOne);
    }

}