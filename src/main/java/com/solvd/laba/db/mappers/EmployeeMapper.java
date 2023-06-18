package com.solvd.laba.db.mappers;

import com.solvd.laba.model.Employee;

public interface EmployeeMapper {
    Employee selectEmployeeById(int id);
}
