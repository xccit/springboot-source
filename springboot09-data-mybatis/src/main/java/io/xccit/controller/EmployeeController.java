package io.xccit.controller;

import io.xccit.entity.Employee;
import io.xccit.mapper.IEmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CH_ywx
 * @date 2023-08-08
 * @description
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private IEmployeeMapper employeeMapper;

    @GetMapping
    public List<Employee> list(){
        return employeeMapper.list();
    }

    @PostMapping
    public String insertEmp(@RequestBody Employee employee){
        int i = employeeMapper.insertEmp(employee);
        if(i > 0){
            return "添加成功";
        }else{
            return "添加失败";
        }
    }
}
