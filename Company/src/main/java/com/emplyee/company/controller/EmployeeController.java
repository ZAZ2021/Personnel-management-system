package com.emplyee.company.controller;

import com.emplyee.company.mapper.DepartmentMapper;
import com.emplyee.company.mapper.EmployeeMapper;
import com.emplyee.company.mapper.RankMapper;
import com.emplyee.company.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {



    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private RankMapper rankMapper;

    //通过mybatis来进行分页展示所有员工信息
    @GetMapping("/find")
    public Map<String,Object> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        Integer total = employeeMapper.selectTotal();
        List<UserInf> data = employeeMapper.findAllEmployee(pageNum,pageSize);
        Map<String,Object> res= new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    //注册新员工
    @PostMapping("/register")
    public boolean register(@RequestBody Employee employee){
        return employeeMapper.createEmployee(employee);
    }

    //用户信息修改
    @PostMapping("/update")
    public Integer update(@RequestBody UserInf userInf) {
        return employeeMapper.updateEmployee(userInf);
    }

    //员工离职
    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable Integer id){
        return employeeMapper.deleteEmployee(id);
    }

    //管理员给新员工入职
    @PostMapping("/create")
    public int create(@RequestBody UserInf userInf){
        String dename=userInf.getDename();
        String duty=userInf.getDuty();
        String name=userInf.getName();
        Integer deid=departmentMapper.selectdeid(dename);
        Integer num = rankMapper.selectnum(duty);
        return employeeMapper.createEmloyee1(name,deid,num);
    }


    //员工登录
    @PostMapping("/login")
    public Integer login(@RequestBody User user){
        //System.out.println("!");
        String username= user.getUsername();
        String password= user.getPassword();
        Employee employee=employeeMapper.login(username,password);
        if(employee==null)
            return 0;
        else{
            Integer num=employee.getNum();//获取num，职位等级
            Integer deid=employee.getDeid();//获取deid，职位部门
            if(num<5)//职位等级大于总监
                return 2;
            else{
                if(num<7&&deid==2)//职位等级大于组长但属于人事部门
                    return 2;
                else
                    return 1;
            }
        }
    }

//    通过id查找员工
    @GetMapping("/findbyId")
    public Map<String,Object> findbyId(@RequestParam Integer pageNum, @RequestParam Integer pageSize,@RequestParam Integer id){
        pageNum=(pageNum-1)*pageSize;
        List<UserInf> data = employeeMapper.findEmployeeByid(pageNum,pageSize,id);
        Integer total = employeeMapper.selectTotalByid(id);
        Map<String,Object> res= new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

//    通过name查找员工
    @GetMapping("/findbyname")
    public Map<String,Object> findbyName(@RequestParam Integer pageNum, @RequestParam Integer pageSize,@RequestParam String name){
        pageNum=(pageNum-1)*pageSize;
        List<UserInf> data = employeeMapper.findEmployeeByname(pageNum,pageSize,name);
        Integer total = employeeMapper.selectTotalByname(name);
        Map<String,Object> res= new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    //通过duty查找员工
    @GetMapping("/findbyDuty")
    public Map<String,Object> findByDuty(@RequestParam Integer pageNum, @RequestParam Integer pageSize,@RequestParam String duty){
        pageNum=(pageNum-1)*pageSize;
        List<UserInf> data = employeeMapper.selectByDuty(pageNum,pageSize,duty);
        Integer total = employeeMapper.selectTotalbyDuty(duty);
        Map<String,Object> res= new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    //职位的修改
    @PostMapping("/updatedepartment")
    public Integer updateDe(@RequestBody UserInf userInf){
        String dename=userInf.getDename();
        String duty=userInf.getDuty();
        Integer id=userInf.getId();
//        System.out.println(dename+duty+id);
//        System.out.println(departmentMapper.selectdeid(dename));
        Integer deid=departmentMapper.selectdeid(dename);
        Integer num=rankMapper.selectnum(duty);
//        System.out.println(deid+num);
        return employeeMapper.updateDepartment(id,num,deid);
    }

    //批量删除
    @PostMapping("/del")
    public Integer del(@RequestBody List<Integer> ids){
        return employeeMapper.del(ids);
    }

    //通过username查找
    @GetMapping("/username")
    public UserInf findIof(@RequestParam String username){
        return employeeMapper.selectByUsername(username);
    }
}
