package io.xccit.mapper;

import io.xccit.entity.Department;
import org.apache.ibatis.annotations.*;

/**
 * @author CH_ywx
 * @date 2023-08-08
 * @description
 */
@Mapper
public interface IDepartmentMapper {

    /**
     * 添加
     * @param department
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id") //指定主键生成
    @Insert("insert into department(departmentName) values (#{departmentName})")
    public int insertDept(Department department);

    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from department where id = #{id}")
    public int deleteDept(Integer id);

    /**
     * 更新
     * @param department
     * @return
     */
    @Update("update department set departmentName = #{departmentName}")
    public int updateDept(Department department);

    @Select("select * from department where id = #{id}")
    public Department getDeptByID(Integer id);
}
