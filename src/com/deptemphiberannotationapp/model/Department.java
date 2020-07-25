package com.deptemphiberannotationapp.model;

import java.util.List;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Table
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dept_id")
	private int deptId;
	@Column(name="dept_name")
	private String deptName;
	@Column(name="dept_loc")
	private String deptLoc;
	@OneToMany(mappedBy="department",cascade=CascadeType.REMOVE)
	
	public Set<Employee> employee;
	public String getDeptLoc() {
		return deptLoc;
	}
	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Department(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}
	
	
	
	
	public Set<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
	public Department() {
		super();
	}
	public Department(int deptId, String deptName, String deptLoc) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}
	

}
