package com.deptemphiberannotationapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class EditEmployee
 */
@WebServlet("/editemployee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession sed = request.getSession();
		int empId=Integer.parseInt(request.getParameter("empId"));
		System.out.println("employee id at edit employee is "+empId);
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		DeptEmpService edfd = new DeptEmpServImpl();
		//Employee emp = (Employee) edfd.readEmployeeServ(empId);
		//Department df = edfd.showDeptServ(emp.getDepartment().getDeptId());
		List<Department> lsd = (List<Department>) sed.getAttribute("lis");
		String deptName = null;
		for (Department department : lsd) {
			if(department.getDeptId() == deptId)
			{
				deptName=department.getDeptName();
			}
		}
		
		//System.out.println("edit page value"+emp.getEmpName());
		
		List<Employee> listFromDept=edfd.readEmpFromDeptServ(deptId);
		
		
		sed.setAttribute("empp", empId);
		request.setAttribute("mainemps", "checktableedit");
		request.setAttribute("empl", empId);
		request.setAttribute("hom", "homep");
		request.setAttribute("addlin", "anemp");
		request.setAttribute("lis", lsd);
		request.setAttribute("val", listFromDept);
		request.setAttribute("deptName", deptName);
		
			RequestDispatcher rd = request.getRequestDispatcher("home3.jsp");
			rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
