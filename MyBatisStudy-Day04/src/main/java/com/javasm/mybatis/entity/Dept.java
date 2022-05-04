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
 * @create: 2022-05-03 10:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private Integer deptId;
    private String deptName;
    private List<Employee> emps;
}