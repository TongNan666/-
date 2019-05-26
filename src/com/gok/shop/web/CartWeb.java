package com.gok.shop.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gok.shop.pojo.Cart;

/**
 * Servlet implementation class CartWeb
 */
@WebServlet("/CartWeb")
public class CartWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartWeb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
        String m=request.getParameter("m");
        switch (m) {
		case "add":
			//��ȡ��ƷId������
			 String nid=request.getParameter("nid");
			 String num=request.getParameter("num");
			 String name=request.getParameter("name");
			 String img=request.getParameter("img");
			 String price=request.getParameter("price");
			 //�ж������Ƿ����
			 //��session��ȡ���ﳵ���Map
			 Map<String,Cart> carts=(Map<String, Cart>) request.getSession().getAttribute("cart");
			//�ս���mapΪ����Ҫ�ȴ���
			 if(carts==null){
			 carts=new HashMap<>();
			 }
			 //���жϸ���Ʒ��û��
			 Cart c=carts.get(nid);
			 if(c==null){    //û�оʹ���һ��
				 c=new Cart();
				 //������Ϣ
				 c.setNid(Integer.parseInt(nid));
				 c.setName(name);
				 c.setImg(img);
				 c.setNum(Integer.parseInt(num));
				 c.setPrice(price);
				 //ע�⣡�����ܸպõ���0
//				 if(c.getNum()==0){
//					 
//				 }
				 //�ŵ����ﳵ
				 carts.put(nid, c);
			 }else{
				 c.setNum(c.getNum()+Integer.parseInt(num));
			 }
			 //����map�ŵ�session��
			 request.getSession().setAttribute("cart", carts);
           //��ӳɹ��������ʾ
			 response.getWriter().println("<srcipt>alert('��ӳɹ�')</srcipt>");
			 request.getRequestDispatcher("/myshop.jsp").forward(request, response);
			break;
		case "list":
			//request session applicationContext  ������jspҳ���л�ȡ���ǵ�ֵ
			break;
		case "del":
			String id=request.getParameter("nid");
			Map<String,Cart> carts1=(Map<String, Cart>) request.getSession().getAttribute("cart");
			carts1.remove(id);
			//request.getRequestDispatcher("/myshop.jsp").forward(request, response);
			break;
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
