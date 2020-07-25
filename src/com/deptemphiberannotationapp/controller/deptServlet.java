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

@WebServlet("/home")
public class deptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public deptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DeptEmpService ded = new DeptEmpServImpl();
		HttpSession sed = request.getSession();
		
		List<Department> ldept = (List<Department>) sed.getAttribute("ldeptj");
		int deptId =ldept.get(0).getDeptId();
		//List<Employee> empl = ded.readEmpFromDeptServ(deptId);
		//Department dep = ded.showDeptServ(deptId);
		//int i=0;
		response.sendRedirect("listEmp?deptId="+deptId);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
