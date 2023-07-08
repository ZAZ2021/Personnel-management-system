package com.emplyee.company.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok的data注解可以代替get和set方法
@Data
//创建无参构造
@NoArgsConstructor
//创建有参构造
@AllArgsConstructor

public class Employee {
    private Integer id;
    private String name;
    private String username;
//    @JsonIgnore
    //忽略该字段，不展示给前端
    private String password;
    private String sex;
    private Integer age;
    private String tel;
    private String address;
    private Integer num;
    private Integer deid;
}

