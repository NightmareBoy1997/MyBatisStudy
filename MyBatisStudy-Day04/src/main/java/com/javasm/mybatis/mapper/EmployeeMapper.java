package com.javasm.mybatis.mapper;

import com.javasm.mybatis.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @projectName: MyBatisStudy
 * @package: com.javasm.mybatis.entity.javasm.mybatis
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-05-03 10:14
 */
public interface EmployeeMapper<insertMoreByList> {

    List<Employee> findEmpByConditionIf(Employee emp);

    List<Employee> findEmpByConditionWhere(Employee emp);

    List<Employee> findEmpByConditionTrim(Employee emp);

    List<Employee> findEmpByConditionChoose(Employee emp);

    int deleteMoreByIdArray(@Param("eids") Integer[] eids);

    int insertMoreByList(@Param("emps")List<Employee> emps);

}