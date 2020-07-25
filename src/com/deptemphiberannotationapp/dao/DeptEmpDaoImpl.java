package com.deptemphiberannotationapp.dao;


import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.deptemphiberannotationapp.Util.HibernateUtil;
import com.deptemphiberannotationapp.model.Department;
import com.deptemphiberannotationapp.model.Employee;


public class DeptEmpDaoImpl implements DeptEmpDao{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	
	public boolean createDept(Department dept) {

		Session session = sessionFactory.openSession();
	    
	    session.beginTransaction();
	    
	    session.save(dept);
	    session.getTransaction().commit();
	return true;
	}

	public boolean updateDept(Department dpt) {
Session session = sessionFactory.openSession();
	    
	    session.beginTransaction();
	    session.update(dpt);
	    session.getTransaction().commit();
		return true;}

	@SuppressWarnings("unchecked")
	public List<Department> readAllDept() {
Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        List<Department> deptList = session.createQuery("FROM Department").list();
        System.out.println("Department List");
        for (Department department : deptList) {
			System.out.println(department.getDeptId() + " "+department.getDeptName()+" "+department.getDeptLoc());
		}
        session.getTransaction().commit();
		
				return deptList;}

	public boolean delteDept(int deptId) {
		
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Department department = (Department)session.get(Department.class, deptId);
        
        session.delete(department);
        session.getTransaction().commit();
        System.out.println("Employee Deleted!!!");
    
		
		return true;}

	public boolean createEmp(Employee employee) {
		
Session session = sessionFactory.openSession();
	    
	    session.beginTransaction();
	    
	    session.save(employee);
	    session.getTransaction().commit();
		
		return true;
		}

	public boolean updateEmp(Employee employee) {
Session session = sessionFactory.openSession();
	    
	    session.beginTransaction();
	    session.update(employee);
	    session.getTransaction().commit();
		
				return true;}

	@SuppressWarnings("unchecked")
	public List<Employee> readEmpFromDept(int deptId) {
		Session session = sessionFactory.openSession();
		   session.beginTransaction();
		   
		   String sqlQuery="select * from employee where dept_emp_fk = :dept_id";
		   SQLQuery query = session.createSQLQuery(sqlQuery);
		   query.addEntity(Employee.class);
		   query.setParameter("dept_id", deptId);
	        List<Employee> employeeList = query.list();
	        System.out.println("Department List");
	        
	        session.getTransaction().commit();
		
	return employeeList;}

	public boolean deleteEmpFromDept(int deptId,int empId) {
		
		Session session = sessionFactory.openSession();
		   session.beginTransaction();
		System.out.println("two values for delete"+deptId + " "+empId);   
		   String sqlQuery="delete from employee where emp_id= :emp_id and dept_emp_fk = :dept_id";
		   SQLQuery query = session.createSQLQuery(sqlQuery);
		   query.addEntity(Employee.class);
		   
		   query.setParameter("emp_id", empId);
		   query.setParameter("dept_id", deptId);
	     query.executeUpdate();
	        System.out.println("Employee Deleted");
	        
	        session.getTransaction().commit();
		
	return true;}
	/*@Override
	public Employee readEmployee(int empId) {
		
		 Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        
	        Employee employee = (Employee)session.get(Employee.class, empId);
	        
	      
	        session.getTransaction().commit();
	        System.out.println("Employee read!!!");
		
		return employee;
	}
	@Override
	public Department showDept(int deptId) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Department dpt = (Department)session.get(Department.class, deptId);
		
		session.getTransaction().commit();
		return dpt;
	}
	
	*/
	

}
