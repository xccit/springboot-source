package io.xccit.mapper;

import io.xccit.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CH_ywx
 * @date 2023-08-08
 * @description
 */
@Repository
public interface IEmployeeMapper {
    /**
     * 添加
     * @param employee
     * @return
     */
    public int insertEmp(Employee employee);

    /**
     * 列表
     * @return
     */
    public List<Employee> list();

}
