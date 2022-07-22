package ems.management.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeModel {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("emailAddress")
	private String emailAddress;
	
	@JsonProperty("createdAt")
	private String createdAt;
	
	@JsonProperty("deletedAt")
	private String deletedAt;
	
	@JsonProperty("updatedAt")
	private String updatedAt;
	
	@JsonProperty("joinDate")
	private String joinDate;
	
	@JsonProperty("employeeSalary")
	private BigDecimal employeeSalary = BigDecimal.ZERO;
	
	@JsonProperty("employeePosition")
	private String employeePosition;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public BigDecimal getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(BigDecimal employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeePosition() {
		return employeePosition;
	}

	public void setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return firstName;
	}

	public void setName(String name) {
		this.firstName = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return emailAddress;
	}

	public void setEmail(String email) {
		this.emailAddress = email;
	}

	public String getCreated_at() {
		return createdAt;
	}

	public void setCreated_at(String created_at) {
		this.createdAt = created_at;
	}

	public String getDeleted_at() {
		return deletedAt;
	}

	public void setDeleted_at(String deleted_at) {
		this.deletedAt = deleted_at;
	}

	public String getUpdated_at() {
		return updatedAt;
	}

	public void setUpdated_at(String updated_at) {
		this.updatedAt = updated_at;
	}
}
