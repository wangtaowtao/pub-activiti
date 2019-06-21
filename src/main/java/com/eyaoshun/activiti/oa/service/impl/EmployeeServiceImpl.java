package com.eyaoshun.activiti.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyaoshun.activiti.oa.dao.IEmployeeMapper;
import com.eyaoshun.activiti.oa.entity.Employee;
import com.eyaoshun.activiti.oa.service.IEmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeMapper iEmployeeDao;

	@Override
	public Employee findEmployeeByName(String name) {
		Employee employee = iEmployeeDao.findEmployeeByName(name);
		return employee;
	}

}
