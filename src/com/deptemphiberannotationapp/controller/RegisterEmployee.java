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
 * Servlet implementation class RegisterEmployee
 */
@WebServlet("/addemployee")
public class RegisterEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptEmpService danew =new DeptEmpServImpl();
		HttpSession sef = request.getSession();
		int deptId = (int) sef.getAttribute("deIdFromLis");
		List<Employee> lsty = danew.readEmpFromDeptServ(deptId);
	
		List<Department> ldeptval = (List<Department>) sef.getAttribute("ldeptj");
		String stg =request.getParameter("empId");
		if(stg==null)
		{
		
		//request.setAttribute("dept",sef.getAttribute("lisvaldept") );
		request.setAttribute("hom", "homep");
		request.setAttribute("valcheck", "regemployee");
		request.setAttribute("lis",ldeptval);
		//request.setAttribute("dval",sef.getAttribute("dval"));
		request.setAttribute("val",lsty);
		request.setAttribute("depId", deptId);
		request.setAttribute("empl", 0);
		RequestDispatcher rd = request.getRequestDispatcher("home3.jsp");
	rd.forward(request, response);}
	else
	{
		int x=Integer.parseInt(stg);
		if(x==0)
		{
			request.setAttribute("hom", "homep");
			request.setAttribute("newtab", "ntabl");
		request.setAttribute("val",lsty);
		request.setAttribute("depId", deptId);
		request.setAttribute("empl", 0);
		RequestDispatcher rd = request.getRequestDispatcher("home3.jsp");
	       rd.forward(request, response);
		}
		
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
