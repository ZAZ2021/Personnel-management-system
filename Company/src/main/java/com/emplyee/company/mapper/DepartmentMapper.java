package com.emplyee.company.mapper;

import com.emplyee.company.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    //通过deid查找部门名dename
    @Select("select dename from department where deid=#{deid}")
    String selectByID(Integer deid);

    //查找deid
    @Select("select deid from department where dename=#{dename}")
    Integer selectdeid(String dename);

    //查找表
    @Select("select * from department")
    List<Department> findtable();
}