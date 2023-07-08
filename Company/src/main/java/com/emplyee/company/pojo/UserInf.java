package com.emplyee.company.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInf {
    private Integer id;
    private String name;
    private String username;
    @JsonIgnore
    //忽略该字段，不展示给前端
    private String password;
    private String sex;
    private Integer age;
    private String tel;
    private String address;
    private Integer num;
    private Integer deid;
    private String duty;
    private String dename;
}
