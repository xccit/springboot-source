package io.xccit.controller;

import io.xccit.entity.Department;
import io.xccit.mapper.IDepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author CH_ywx
 * @date 2023-08-08
 * @description
 */
@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private IDepartmentMapper departmentMapper;

    @GetMapping("/{id}")
    public Department getDeptByID(@PathVariable Integer id){
        Department deptByID = departmentMapper.getDeptByID(id);
        return deptByID;
    }

    @PostMapping
    public String insertDept(@RequestBody Department department){
        System.out.println(department);
        int i = departmentMapper.insertDept(department);
        if (i != 0){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    @PutMapping
    public String updateDept(@RequestBody Department department){
        int i = departmentMapper.updateDept(department);
        if (i != 0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteDept(@PathVariable Integer id){
        int i = departmentMapper.deleteDept(id);
        if (i != 0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }
}
