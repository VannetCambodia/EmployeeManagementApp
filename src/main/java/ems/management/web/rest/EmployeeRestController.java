package ems.management.web.rest;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.BooleanLiteral;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ems.management.Util.EncryptUtil;
import ems.management.Util.TokenUtil;
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
		boolean isSuccess = false;
		String msg = "";
		String statusCode = "";
		try {
			
			if(!employeeModel.getEmailAddress().isEmpty()
					&& employeeModel.getEmailAddress() == null) {
				throw new ValidateFieldException("Email should not be null.");
			}
			
			EmployeeModel employeeDetail = employeeImp.retrieveEmployeeDetail(employeeModel);
			if(employeeDetail != null) throw new Exception("Email was duplicated.");
			
			String encryptPassword = EncryptUtil.encryptPassword(employeeModel.getPassword());
			employeeModel.setPassword(encryptPassword);
			employeeImp.registerEmployee(employeeModel);
		}catch (ValidateFieldException e) {
			e.printStackTrace();
		}catch (Exception e) {
			isSuccess = false;
			statusCode = "400";
			msg = "Bad Request";
		}
		
		responseData.put("success"	, isSuccess);
		responseData.put("status"	, statusCode);
		responseData.put("message"	, msg);
		responseData.put("body"		, employeeModel);
		
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
	
	@GetMapping("/retrieveEmployees")
	public HashMap<String, Object> retrieveEmployList(@RequestParam("pageNumber") int pageNumber,
			@RequestParam("pageSize") int pageSize){
		List<EmployeeModel> employeeList = new ArrayList<>();
		HashMap<String, Object> responseData = new HashMap<>();
		boolean isSuccess = false;
		String msg        = "";
		String statusCode = "";
		
		int offset = (pageNumber - 1) *  pageSize;
		employeeList = employeeImp.retrieveEmployeeList(offset, pageSize);
		
		isSuccess  = true;
		msg        = "Success";
		statusCode = "200";
		
		responseData.put("success"	, isSuccess);
		responseData.put("status"	, statusCode);
		responseData.put("message"	, msg);
		responseData.put("body"		, employeeList);
		
		return responseData;
	}
	
	@PostMapping("/login")
	public HashMap<String, Object> login(@RequestBody EmployeeModel employeeModel) throws NoSuchAlgorithmException{
		EmployeeModel employee               = new EmployeeModel();
		HashMap<String, Object> responseData = new HashMap<>();
		boolean isSuccess = false;
		String msg        = "";
		String statusCode = "";
		String token = "";
		try {
			
			String password = EncryptUtil.encryptPassword(employeeModel.getPassword());
			employee        = employeeImp.retrieveEmployeeDetail(employeeModel);
			
			if(employee == null) throw new NotFoundException("Employee Not Found.");
			
			if(password.equals(employee.getPassword())) {
				msg 		= "Login Successfully.";
				statusCode  = "200";
				isSuccess   = true;
//				token      = TokenUtil.generateAccessToken(employee);
			}
			
		}catch (NotFoundException e) {
			isSuccess   = false;
			msg 		= "Employee Not Found.";
			statusCode  = "404";
		}
		
		responseData.put("success"	, isSuccess);
		responseData.put("status"	, statusCode);
		responseData.put("message"	, msg);
		responseData.put("body"		, employee);
		responseData.put("token"    , token);
		
		return responseData;
	}
}
