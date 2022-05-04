package com.javasm.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javasm.mybatis.bean.Employee;
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
 * @create: 2022-05-05 0:48
 */
public class PageHelperTest {
    EmployeeMapper mapper = SqlSessionUtil.getSqlSession().getMapper(EmployeeMapper.class);

    /**
     * 分页  limit index pageSize
     * index：当前页的起始索引 index=(pageNum-1)*pageSize
     * pageSize：每页显示的数量
     * pageNum：当前页的页码
     *
     * 使用mybatis的分页插件 实现分页功能
     *  1. 需要在查询记录之前开启分页
     *      PageHelper.startPage(int pageNum,int pageSize)
     *  2. 在查询之后获取分页相关信息
     *      PageInfo<Employee>page = new PageInfo(list,5);
     *      第一个参数list ： 表示当前分页的数据
     *      第二参数5：表示当前导航分页的页码个数
     *
     *
     */


    @Test
    public void pageHelperTest(){
        PageHelper.startPage(4,3);

        final List<Employee> allEmp = mapper.selectByExample(null);
        allEmp.forEach(System.out::println);

        // 方式1： 获取查询结果部分分页信息
/*        final Page<Object> pageHelper = PageHelper.startPage(2,3);
        System.out.println("** pageHelper对象 **");
        System.out.println(pageHelper);*/

        // 方式2： 获取查询结果全部分页信息
        // 可以获取 页码导航栏的相关所有页码信息
        PageInfo<Employee> pageInfo = new PageInfo<>(allEmp,5);
        System.out.println("** pageInfo **");
        System.out.println(pageInfo);

    }


}