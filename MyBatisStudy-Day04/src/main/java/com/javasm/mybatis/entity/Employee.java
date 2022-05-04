package com.javasm.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @projectName: MyBatisStudy
 * @package: com.javasm.mybatis.entity
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-05-03 10:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    private Integer empId;
    private String empName;
    private Integer age;
    private String gender;
    private String email;
    private Dept dept;
}