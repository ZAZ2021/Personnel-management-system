package com.emplyee.company.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接受前端登录请求的参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String username;
    private String password;


}
