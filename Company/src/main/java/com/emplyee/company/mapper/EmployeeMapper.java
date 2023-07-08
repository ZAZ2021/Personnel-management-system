package com.emplyee.company.mapper;

import com.emplyee.company.pojo.Employee;
import com.emplyee.company.pojo.User;
import com.emplyee.company.pojo.UserInf;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

//加入mapper注解，可以使该mapper被直接使用
@Mapper
public interface EmployeeMapper  {

    //展示所有员工信息(分页查找）
    @Select("SELECT * FROM employee,department,ran WHERE employee.deid=department.deid " +
            "AND employee.num=ran.num limit #{pageNum}, #{pageSize}")
    List<UserInf> findAllEmployee(Integer pageNum, Integer pageSize);

    //查询总数
    @Select("select count(*) from employee")
    Integer selectTotal();

    //新员工入职
    @Insert("insert into employee(name,num,deid) values (#{name},#{num},#{deid})")
    int createEmloyee1(String name,Integer deid,Integer num);

    //员工离职
    @Delete("delete from employee where id=#{id}")
    int deleteEmployee(Integer id); //员工离职

    //员工的职位调整
    @Update("update employee set num=#{num},deid=#{deid} where id=#{id}")
    Integer updateDepartment(Integer id,Integer num,Integer deid);

    //通过id查找
    @Select("SELECT * FROM employee,department,ran WHERE employee.deid=department.deid AND employee.num=ran.num AND id=#{id} limit #{pageNum}, #{pageSize}")
    List<UserInf> findEmployeeByid(Integer pageNum,Integer pageSize,Integer id);

    //查询总数通过id
    @Select("select count(*) from employee where id=#{id}")
    Integer selectTotalByid(Integer id);

    //通过name找
    @Select("SELECT * FROM employee,department,ran WHERE employee.deid=department.deid AND employee.num=ran.num AND name=#{name} limit #{pageNum}, #{pageSize}")
    List<UserInf> findEmployeeByname(Integer pageNum,Integer pageSize,String name);

    //查询总数通过name
    @Select("select count(*) from employee where name=#{name}")
    Integer selectTotalByname(String name);

    //通过username来查找
    @Select("SELECT * FROM employee,department,ran WHERE employee.deid=department.deid AND employee.num=ran.num AND username=#{username}")
    UserInf selectByUsername(String username);

    //新员工注册
   // @Insert("insert into employee(username,password) values (#{username},#{password})")
    boolean createEmployee(Employee employee);



    //用户信息修改
    int updateEmployee(UserInf userInf);



    //员工登录
    @Select("select * from employee where username=#{username} and password=#{password}")
    Employee login(String username,String password);

    //通过职位查询
    @Select("SELECT * FROM employee,department,ran WHERE employee.deid=department.deid AND employee.num=ran.num AND duty=#{duty} limit #{pageNum}, #{pageSize}")
    List<UserInf> selectByDuty(Integer pageNum, Integer pageSize,String duty);

    //通过职位查询总数
    @Select("select count(*) from employee,ran where employee.num=ran.num AND duty=#{duty}")
    Integer selectTotalbyDuty(String duty);



//    Employee find(String name);

    //批量删除
    Integer del(List<Integer> ids);
}
