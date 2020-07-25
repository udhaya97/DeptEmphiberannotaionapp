package com.deptemphiberannotationapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_id")
	private int empId;
	@Column(name="emp_name")
	private String empName;
	@Column(name="dob")
	private String dateOfBirth;
	@Column(name="mail_id")
	private String mailId;
	@Column(name="mobile_no")
	private long mobileNo;
	@Column(name="salary")
	private float salary;
	//private int deptEmpId;
	@Column(name="company_name")
	private String companyName;
	@ManyToOne
	@JoinColumn(name="dept_emp_fk") 
	private Department department;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/*public int getDeptEmpId() {
		return deptEmpId;
	}
	public void setDeptEmpId(int deptEmpId) {
		this.deptEmpId = deptEmpId;
	}*/
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Employee(int empId, String empName, String dateOfBirth, String mailId, long mobileNo, float salary,
			 String companyName, Department department) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.dateOfBirth = dateOfBirth;
		this.mailId = mailId;
		this.mobileNo = mobileNo;
		this.salary = salary;
		//this.deptEmpId = deptEmpId;
		this.companyName = companyName;
		this.department = department;
	}
	public Employee() {
		super();
	}
	
	/*public Employee(int empId, String empName, String dateOfBirth, String mailId,int deptEmpId, long mobileNo, float salary,
			 String companyName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.dateOfBirth = dateOfBirth;
		this.mailId = mailId;
		this.mobileNo = mobileNo;
		this.salary = salary;
		this.deptEmpId = deptEmpId;
		this.companyName = companyName;
	}*/
	
	

}
