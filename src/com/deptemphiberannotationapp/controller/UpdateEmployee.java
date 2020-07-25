package com.deptemphiberannotationapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deptemphiberannotationapp.dao.DeptEmpDao;
import com.deptemphiberannotationapp.dao.DeptEmpDaoImpl;
import com.deptemphiberannotationapp.model.Department;
import com.deptemphiberannotationapp.model.Employee;
import com.deptemphiberannotationapp.service.DeptEmpServImpl;
import com.deptemphiberannotationapp.service.DeptEmpService;

/**
 * Servlet implementation class UpdateEmployee
 */
@WebServlet("/updateemployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DeptEmpService ded = new DeptEmpServImpl();
		HttpSession mlk = request.getSession();
		//Employee erd = (Employee)mlk.getAttribute("empp");
		//String idv = request.getParameter("empId");
		int empId =(int) mlk.getAttribute("empp");
		System.out.println("id val"+empId);
		String empName=request.getParameter("empName");
		System.out.println("employee Name"+empName);
		String dob=request.getParameter("dob");
		System.out.println("dob "+dob);
		String mailId=request.getParameter("mailId");
		System.out.println("mail Id"+mailId);
		String depsample = request.getParameter("deptEmpName");
		List<Department> lsv = ded.readAllDeptServ();
		
		int studeptid = 0;
		for (Department department : lsv) {
			if(department.getDeptName().equals(depsample))
			{
				studeptid= department.getDeptId();
			}
		}
		
		System.out.println("values update employee "+ studeptid);
		long mob = Long.parseLong(request.getParameter("mobileNo"));
		float sal = Float.parseFloat(request.getParameter("salary"));
		String comName = request.getParameter("companyName");
		Department deps = new Department();
		deps.setDeptId(studeptid);
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setMailId(mailId);
		emp.setDateOfBirth(dob);
		emp.setDepartment(deps);
		emp.setMobileNo(mob);
		emp.setSalary(sal);
		emp.setCompanyName(comName);
		
		System.out.println("Values from update employee"+empId + " "+empName+" "+mailId+ " "+dob + " "+studeptid+" "+mob+ " "+sal + " "+ comName);
		
		System.out.println("values for updating");
		//System.out.println(empId+" "+empName + " "+ mailId+" "+dob+" "+studeptid);
		
		ded.updateEmpServ(emp);
		HttpSession sea = request.getSession();
		sea.setAttribute("submitDone","done");
		response.sendRedirect("listEmp?deptId="+studeptid);
		
		
	}

}
