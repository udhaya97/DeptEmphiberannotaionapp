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
import com.deptemphiberannotationapp.service.DeptEmpServImpl;
import com.deptemphiberannotationapp.service.DeptEmpService;

@WebServlet("/regDept")
public class RegDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sed = request.getSession();
		
		List<Department> ldepty = (List<Department>) sed.getAttribute("ldeptj");
		request.setAttribute("adddept", "regdept");
		request.setAttribute("deptlv", ldepty);
		request.setAttribute("hoser", "hseval");
		request.setAttribute("deptva", 0);
		RequestDispatcher rdf = request.getRequestDispatcher("home3.jsp");
		rdf.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
