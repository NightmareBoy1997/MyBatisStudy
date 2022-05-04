package com.javasm.mybatis.mapper;

import com.javasm.mybatis.entity.Dept;
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
 * @create: 2022-05-02 21:14
 */
public interface EmployeeMapper {

    /**
     * 处理字段名与属性不一致的情况一
     * 使用别名
     */
    Employee getEmpByIdWithLabel(@Param("empId") Integer empId);

    /**
     * 处理字段名与属性不一致的情况二
     * 使用resultMap自定义映射关系
     */
    Employee getEmpByIdWithResultMap(@Param("empId") Integer empId);

    /**
     * 处理字段名与属性名不一致的情况三
     * 在全局配置中加入mapUnderscoreToCamelCase
     */


    /**
     * 处理多对一的映射关系 方式一
     * 级联
     */
    Employee getEmpWithTier(@Param("empId") Integer empId);

    /**
     * 处理多对一的映射关系 方式二
     * 使用association处理映射关系
     */
    Employee getEmpWithAssociation(@Param("empId")Integer empId);
    /**
     * 处理多对一的映射关系 方式三
     * 使用分步查询
     */



    /**
     * 分布查询指定emp_Id员工的部门信息，步骤一
     */
    Employee getEmpAndDeptStepOne(@Param("empId") Integer empId);


    /**
     * 分布查询dept_id部门的所有员工集合 步骤二
     */
    List<Employee> getDeptAndEmpStepTwo(@Param("deptId") Integer deptId);


}