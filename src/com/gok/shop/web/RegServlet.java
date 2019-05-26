package com.gok.shop.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gok.shop.dao.LoginDao;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao dao=new LoginDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
	    String password=request.getParameter("password");
	    System.out.println("name ："+name);
		if(dao.isExist(name)==false){ 
			int data=dao.insert_prepare(name,phone, password);
			
			//转发到Regsuccess.jsp
			 request.setAttribute("hello", "注册成功");
	         request.getRequestDispatcher("/Regsuccess.jsp").forward(request, response);
		}
		else{
			response.setHeader("refresh", "2;URL=Regfailed.jsp");
		}
		
	}

				//重定向到Regsuccess.jsp
//				 response.sendRedirect("Regsuccess.jsp");
		

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
