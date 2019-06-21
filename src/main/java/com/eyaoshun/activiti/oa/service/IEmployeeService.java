package com.eyaoshun.activiti.oa.service;

import com.eyaoshun.activiti.oa.entity.Employee;

public interface IEmployeeService
{
    Employee findEmployeeByName(String name);
}
