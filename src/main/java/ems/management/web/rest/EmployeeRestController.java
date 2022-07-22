package ems.management.web.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ems.management.Util.ValidateUtil;
import ems.management.Util.exception.NotFoundException;
import ems.management.Util.exception.ValidateFieldException;
import ems.management.model.EmployeeModel;
import ems.management.service.imp.EmployeeImp;

@RestController
@RequestMapping("/employee/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeImp employeeImp;
	
	@PostMapping("/register")
	public HashMap<String, Object> registerEmployee(@RequestBody EmployeeModel employeeModel){
		
		HashMap<String, Object> responseData = new HashMap<>();
		try {
			
			if(!employeeModel.getEmailAddress().isEmpty()
					&& employeeModel.getEmailAddress() == null) {
				throw new ValidateFieldException("Email should not be null.");
			}
			
			EmployeeModel employeeDetail = employeeImp.retrieveEmployeeDetail(employeeModel);
			if(employeeDetail != null) throw new Exception("Email was duplicated.");
			
			employeeImp.registerEmployee(employeeModel);
			
			responseData.put("success"	, true);
			responseData.put("status"	, "201");
			responseData.put("message"	, "Register Successfully.");
			responseData.put("body"		, employeeDetail);
		}catch (ValidateFieldException e) {
			e.printStackTrace();
		}catch (Exception e) {
			responseData.put("body"		, "This is testing for exception");
		}
		
		return responseData;
	}
	
	@PostMapping("/update")
	public HashMap<String, Object> updateEmployee(@RequestBody EmployeeModel employeeModel){
		
		try {
			employeeImp.updateEmployee(employeeModel);
		}catch (NotFoundException e) {
			e.printStackTrace();
		}
		return new HashMap<>();
	}
	
	@PostMapping("/delete")
	public HashMap<String, Object> updateEmployee(@RequestParam("id") int id){
		
		try {
			employeeImp.deleteEmployee(id);
		}catch (NotFoundException e) {
			e.printStackTrace();
		}
		return new HashMap<>();
	}
	
	@GetMapping("/delete")
	public HashMap<String, Object> retrieveEmployList(@RequestParam("pageNumber") int pageNumber,
			@RequestParam("pageSize") int pageSize){
		List<EmployeeModel> employeeList = new ArrayList<>();
		try {
			employeeList = employeeImp.retrieveEmployeeList(pageNumber, pageSize);
		}catch (NotFoundException e) {
			e.printStackTrace();
		}
		return new HashMap<>();
	}
	
	@PostMapping("/login")
	public HashMap<String, Object> login(@RequestBody EmployeeModel employeeModel){
		EmployeeModel employee = new EmployeeModel();
		try {
			employee = employeeImp.retrieveEmployeeDetail(employeeModel);
		}catch (NotFoundException e) {
			e.printStackTrace();
		}
		return new HashMap<>();
	}
}
