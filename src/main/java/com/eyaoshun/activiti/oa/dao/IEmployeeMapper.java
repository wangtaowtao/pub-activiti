package com.eyaoshun.activiti.oa.dao;

import com.eyaoshun.activiti.oa.entity.Employee;

public interface IEmployeeMapper
{
    Employee findEmployeeByName(String name);
    
    Employee findEmployeeById(Long id);
}