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
import javax.websocket.server.PathParam;

import com.deptemphiberannotationapp.dao.DeptEmpDao;
import com.deptemphiberannotationapp.dao.DeptEmpDaoImpl;
import com.deptemphiberannotationapp.model.Department;
import com.deptemphiberannotationapp.model.Employee;
import com.deptemphiberannotationapp.service.DeptEmpServImpl;
import com.deptemphiberannotationapp.service.DeptEmpService;

/**
 * Servlet implementation class ListEmpFromDept
 */
@WebServlet("/listEmp")
public class ListEmpFromDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmpFromDept() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service()
    {
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("get");
		DeptEmpService ded = new DeptEmpServImpl();
		String x = request.getParameter("deptId");
		
		System.out.println("dept id"+x);
		int xt = Integer.parseInt(x);
		System.out.println("int val "+xt);
		List<Employee> ldeptu = ded.readEmpFromDeptServ(xt);
		//Department det =ded.showDeptServ(xt);
		
		HttpSession sess = request.getSession();
		List<Department> lks = (List<Department>) sess.getAttribute("ldeptj");
		
		
		sess.setAttribute("deIdFromLis", xt);
		sess.setAttribute("emplvaldept", ldeptu);
		sess.setAttribute("lis", lks);
		//sess.setAttribute("dval", det);
		sess.setAttribute("val", ldeptu);
		
			System.out.println("values from listemp : ");
			for (Employee employee : ldeptu) {
				System.out.println(employee.getEmpName());
			}
			request.setAttribute("val", ldeptu);
			request.setAttribute("lis", lks);
			//request.setAttribute("dval", det);
			request.setAttribute("hom", "homep");
			//request.setAttribute("countv", sess.getAttribute("couval"));
			//request.setAttribute("mess", "no data available");
			//request.setAttribute("deptnam", arg1);
			RequestDispatcher rd = request.getRequestDispatcher("home3.jsp");
			rd.forward(request, response);}
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get"+"value is"+request.getParameter("cgh"));
		System.out.println(request.getParameter("deptId"));
	}

}
