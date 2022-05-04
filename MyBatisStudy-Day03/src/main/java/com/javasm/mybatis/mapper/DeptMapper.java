package com.javasm.mybatis.mapper;

import com.javasm.mybatis.entity.Dept;
import com.javasm.mybatis.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @projectName: MyBatisStudy
 * @package: com.javasm.mybatis.mapper
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-05-02 21:12
 */
public interface DeptMapper {

    /**
     * 使用resultMap自定义映射处理字段名与属性不一致的情况
     */
    Dept getDeptByDeptId(@Param("deptId")Integer deptId);

    /**
     * 处理一对多的映射关系 方式一
     * 使用collection
     */
    Dept getDeptWithCollection(@Param("deptId")Integer deptId);

    /**
     * 处理一对多的映射关系 方式二
     * 使用分步查询
     */


    /**
     * 分布查询指定emp_Id员工的部门信息，步骤二
     */
    Dept getEmpAndDeptStepTwo(@Param("deptId")Integer deptId);

    /**
     * 分布查询 指定dept_id部门的所有员工集合 步骤一
     */
    Dept getDeptAndEmpStepOne(@Param("deptId")Integer deptId);

}