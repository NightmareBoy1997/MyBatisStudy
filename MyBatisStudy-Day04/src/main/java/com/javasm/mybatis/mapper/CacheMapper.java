package com.javasm.mybatis.mapper;

import com.javasm.mybatis.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @projectName: MyBatisStudy
 * @package: com.javasm.mybatis.mapper
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-05-03 23:41
 */
public interface CacheMapper {

    Employee getEmployeeById(@Param("empId")Integer empId);


    List<Employee>  getAllEmployee();

}