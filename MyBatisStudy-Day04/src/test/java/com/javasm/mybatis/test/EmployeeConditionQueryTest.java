package com.javasm.mybatis.test;

import com.javasm.mybatis.entity.Employee;
import com.javasm.mybatis.mapper.EmployeeMapper;
import com.javasm.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: MyBatisStudy
 * @package: com.javasm.mybatis
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-05-03 10:08
 */
public class EmployeeConditionQueryTest {
    EmployeeMapper empMapper = SqlSessionUtil.getSqlSession().getMapper(EmployeeMapper.class);

    /**
     * 动态SQL：
     * 1、if：根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
     * 2、where：
     * 当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and或or去掉
     * 当where标签中没有内容时，此时where标签没有任何效果
     * 注意：where标签不能将其中内容后面多余的and或or去掉
     * 3、trim：
     * 若标签中有内容时：
     * prefix|suffix：将trim标签中内容前面或后面添加指定内容
     * suffixOverrides|prefixOverrides：将trim标签中内容前面或后面去掉指定内容
     * 若标签中没有内容时，trim标签也没有任何效果
     * 4、choose、when、otherwise，相当于if...else if...else
     * when至少要有一个，otherwise最多只能有一个
     * 5、foreach
     * collection:设置需要循环的数组或集合
     * item:表示数组或集合中的每一个数据
     * separator:循环体之间的分割符
     * open:foreach标签所循环的所有内容的开始符
     * close:foreach标签所循环的所有内容的结束符
     * 6、sql标签
     * 设置SQL片段：<sql id="empColumns">eid,emp_name,age,sex,email</sql>
     * 引用SQL片段：<include refid="empColumns"></include>
     */





    @Test
    public void findEmpByConditionIf(){
        Employee emp = new Employee();
        emp.setEmail("123@163.com");
        emp.setGender("男");
        System.out.println(emp);
        final List<Employee> empList = empMapper.findEmpByConditionIf(emp);
        System.out.println(empList);
    }


    @Test
    public void findEmpConditionQuery(){
        Employee emp = new Employee();
        emp.setEmpName("tom");
        emp.setAge(33);
        emp.setEmail("123@163.com");
        emp.setGender("男");
        final List<Employee> empByCondition = empMapper.findEmpByConditionWhere(emp);
        System.out.println(empByCondition);
    }


    @Test
    public void findEmpByConditionTrim(){
        Employee emp = new Employee();
        emp.setEmpName("tom");
        emp.setAge(33);
        emp.setEmail("123@163.com");
        emp.setGender("男");
        final List<Employee> empByCondition3 = empMapper.findEmpByConditionTrim(emp);
        System.out.println(empByCondition3);
    }


    @Test
    public void findEmpByConditionChoose(){
        Employee emp = new Employee();
        emp.setEmpName("tom");
        emp.setAge(33);
        emp.setEmail("123@163.com");
        emp.setGender("男");
        final List<Employee> empByConditionChoose = empMapper.findEmpByConditionChoose(emp);
        System.out.println(empByConditionChoose);
    }

    @Test
    public void deleteEmpByIdArray(){
        Integer[] eids = new Integer[]{18,19,20};
        final int deleteNumber= empMapper.deleteMoreByIdArray(eids);
        System.out.println(deleteNumber);
    }

    @Test
    public void insetMoreByListTest(){
        List<Employee> emps = new ArrayList<Employee>(10);
        emps.add(new Employee(null,"insertMore1",12,"男","123@qq.com",null));
        emps.add(new Employee(null,"insertMore2",13,"男","123@qq.com",null));
        emps.add(new Employee(null,"insertMore3",14,"男","123@qq.com",null));
        emps.add(new Employee(null,"insertMore4",15,"男","123@qq.com",null));
        emps.add(new Employee(null,"insertMore5",16,"男","123@qq.com",null));
        final int insertNubmer = empMapper.insertMoreByList(emps);
        System.out.println(insertNubmer);
    }


}