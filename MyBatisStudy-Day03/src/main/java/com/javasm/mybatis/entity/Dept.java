package com.javasm.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @projectName: MyBatisStudy
 * @package: com.javasm.mybatis.entity
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-05-02 21:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer deptId;
    private String deptName;
    private List<Employee> emps;
}