package com.solvd.laba.db.mappers;

import com.solvd.laba.model.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapperJava {
    @Select("SELECT id,name FROM Employees WHERE id = #{id}")
    Employee selectEmployeeById(int id);
}
