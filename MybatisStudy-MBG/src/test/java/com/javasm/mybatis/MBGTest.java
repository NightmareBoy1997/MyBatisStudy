package com.javasm.mybatis;

import com.javasm.mybatis.bean.Employee;
import com.javasm.mybatis.bean.EmployeeExample;
import com.javasm.mybatis.mapper.EmployeeMapper;
import com.javasm.mybatis.util.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

/**
 * @projectName: MyBatisStudy
 * @package: com.javasm.mybatis
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-05-04 23:26
 */
public class MBGTest {

    EmployeeMapper mapper = SqlSessionUtil.getSqlSession().getMapper(EmployeeMapper.class);

    @Test
    public void InsertEmpTest() {
        Employee emp = new Employee();
        emp.setAge(22);
        emp.setEmpName("mbgInsert");
        emp.setGender("男");
        emp.setEmail("123@163.com");
        final int insert = mapper.insert(emp);
    }


    @Test
    public void selectEmpTest(){
        // 查询所有员工
/*        Employee emp1=new Employee();
        emp1.setGender("男");
        final List<Employee> emps1 = mapper.selectByExample(null);
        emps1.forEach(System.out::println);*/

        // 条件查询
        // select emp_id, emp_name, age, gender, email, dept_id from tb_employees WHERE ( emp_name like ? and age <= ? ) or( gender = ? )
        final EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andEmpNameLike("%insert%").andAgeLessThanOrEqualTo(13);
        employeeExample.or().andGenderEqualTo("女");
        final List<Employee> emps2 = mapper.selectByExample(employeeExample);
        emps2.forEach(System.out::println);
    }


    @Test
    public void deleteEmpTest(){
        final int i = mapper.deleteByPrimaryKey(10);
        System.out.println(i);
    }


    @Test
    public void updateEmpTest(){
        Employee emp = new Employee();
        emp.setAge(22);
        emp.setEmpName("MBGupdate");
        emp.setGender("男");
        emp.setEmpId(17);
        final int i = mapper.updateByPrimaryKey(emp);
//        mapper.updateByPrimaryKeySelective(emp);
    }

}