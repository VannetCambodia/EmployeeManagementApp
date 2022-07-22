package ems.management.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ems.management.model.EmployeeModel;

public interface EmployeeDao {

	void registerEmployee(EmployeeModel employeeModel);
	
	void updateEmployee(EmployeeModel employeeModel);
	
	void deleteEmployee(int id);
	
	List<EmployeeModel> retrieveEmployeeList(@Param("pageNumber") int pageNumber,
			@Param("pageSize") int pageSize);
	
	EmployeeModel retrieveEmployeeDetail(EmployeeModel employeeModel);
}
