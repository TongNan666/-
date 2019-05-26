package com.gok.shop.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gok.shop.dao.LoginDao;
import com.gok.shop.pojo.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       LoginDao dao=new LoginDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=GBK");
	    String m=request.getParameter("m");
		//һ���԰��û���Ϣȫ����ѯ����  Ȼ��Ƚ���ص����� 
		//����Ҫ��ѯ4�� 
		if("get".equals(m)){
			String name=request.getParameter("name");
			 String password=request.getParameter("password");
			String phone=request.getParameter("phone");
			Login login=dao.getAll(name);
			if(!login.getPassword().equals(password)){
				System.out.println("�������");
			}
			else if(!login.getState().equals("OK")){
				System.out.println("�û��ѱ����");
			}else{
			 Cookie cookie1=new Cookie("name", name);
			 cookie1.setMaxAge(60*60*24*60);
			 HttpSession session=request.getSession();
			 session.setAttribute("password", password);
			 response.getWriter().print("��¼�ɹ�");
			 request.setAttribute("login", login);
        	 //ת������Ʒ����ҳ
        	 request.getRequestDispatcher("/index.jsp").forward(request, response);
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


//if(dao.isExist(name)==false){
//	response.getWriter().println("�û���������");
//}else{
//	if(dao.ispassword(name, password)==false){
//		response.getWriter().println("�������");
//	}else{
//		if(dao.isstate(name)==false){
//	response.getWriter().println("�û��ѱ����");
//}else{
