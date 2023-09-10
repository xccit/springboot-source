package io.xccit.controller;

import io.xccit.dao.DepartmentDao;
import io.xccit.dao.EmployeeDao;
import io.xccit.entity.Department;
import io.xccit.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author CH_ywx
 * @date 2023-07-31
 * @description 客户控制器
 */
@Controller
@RequestMapping("/emp")
public class EmployeeController {

    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 获取员工列表
     * @param model
     * @return
     */
    @GetMapping
    public String list(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps",emps);
        return "emp/list";
    }

    /**
     * 跳转添加页面
     * @param model
     * @return
     */
    @GetMapping("/empAdd")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        model.addAttribute("title","添加员工");
        return "emp/add";
    }

    /**
     * 员工添加
     * @param employee 自动封装请求参数,将参数与对象属性一一对应封装
     * @return
     */
    @PostMapping
    public String addEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        // 添加完成后重定向到 get-->/emp 员工列表请求
        return "redirect:/emp";
    }

    /**
     * 跳转到修改页面
     * @param id
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/{id}")
    public String toEditPage(@PathVariable Integer id,Model model,HttpServletRequest request){
        request.setAttribute("title","修改员工"); //表单上方标题
        //查出员工
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //查出部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    /**
     * 修改员工
     * @param employee
     * @return
     */
    @PutMapping
    public String editEmployee(Employee employee){
        logger.info("准备修改的员工:",employee);
        employeeDao.save(employee); //修改假数据,集合中ID唯一,修改此项
        return "redirect:/emp";
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeDao.delete(id);
        return "redirect:/emp";
    }
}
