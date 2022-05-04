package com.javasm.mybatis.test;

import com.javasm.mybatis.entity.Dept;
import com.javasm.mybatis.entity.Employee;
import com.javasm.mybatis.mapper.DeptMapper;
import com.javasm.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @projectName: MyBatisStudy
 * @package: com.javasm.mybatis.test
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-05-02 21:25
 */
public class DeptSelectTest {
    final DeptMapper deptMapper = SqlSessionUtils.getSqlSession().getMapper(DeptMapper.class);

    @Test
    public void getDeptByIdTest() {
        final Dept deptByDeptId = deptMapper.getDeptByDeptId(3);
        System.out.println(deptByDeptId);
    }

    @Test
    public void getDeptWithCollection(){
        final Dept deptWithCollection = deptMapper.getDeptWithCollection(2);
        System.out.println(deptWithCollection);
    }



    @Test
    public void getDeptAndEmpStep(){
        final Dept deptAndEmpStepOne = deptMapper.getDeptAndEmpStepOne(2);
        System.out.println(deptAndEmpStepOne.getDeptName());
    }




}