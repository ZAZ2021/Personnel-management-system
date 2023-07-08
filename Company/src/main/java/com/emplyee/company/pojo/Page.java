package com.emplyee.company.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    private Integer pageNum;
    private Integer pageSize;
    private Integer id;
    private String name;
}
