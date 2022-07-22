package ems.management.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ems.management.dao.EmployeeDao;
import ems.management.model.EmployeeModel;
import ems.management.service.api.EmployeeService;

@Service
public class EmployeeImp implements EmployeeService  {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void registerEmployee(EmployeeModel employeeModel) {
		employeeDao.registerEmployee(employeeModel);
	}

	@Override
	public void updateEmployee(EmployeeModel employeeModel) {
		employeeDao.updateEmployee(employeeModel);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}

	@Override
	public List<EmployeeModel> retrieveEmployeeList(int pageNumber, int pageSize) {
		return employeeDao.retrieveEmployeeList(pageNumber, pageSize);
	}

	@Override
	public EmployeeModel retrieveEmployeeDetail(EmployeeModel employeeModel) {
		return employeeDao.retrieveEmployeeDetail(employeeModel);
	}

	

}
