package com.gok.shop.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gok.shop.dao.OrderDao;
import com.gok.shop.pojo.TOrder;
import com.gok.shop.pojo.TOrderItem;

import javafx.scene.Parent;

/**
 * Servlet implementation class Myorder
 */
@WebServlet("/Myorder")
public class Myorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       OrderDao dao=new OrderDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myorder() {
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
			int order_id=Integer.parseInt(request.getParameter("order_id"));
			int ncount=Integer.parseInt(request.getParameter("ncount"));
			float nprice=Float.parseFloat(request.getParameter("nprice"));
			float ntotalprice=Float.parseFloat(request.getParameter("ntotalprice"));
			 String ssname=request.getParameter("ssname");
			 String ssaddress=request.getParameter("ssaddress");
			 String ssphone=request.getParameter("ssphone");
			 String smsg=request.getParameter("smsg");
			 //�ж������Ƿ����
			 //��session��ȡ���ﳵ���Map
			 Map<Integer,TOrderItem> carts=(Map<Integer, TOrderItem>) request.getSession().getAttribute("Orderitem");
			//�ս���mapΪ����Ҫ�ȴ���
			 if(carts==null){
			 carts=new HashMap<>();
			 }
			 //���жϸ���Ʒ��û��
			 TOrderItem c=carts.get(order_id);
			 if(c==null){    //û�оʹ���һ��
				 c=new TOrderItem();
				 //������Ϣ
				 c.setNcount(ncount);
				 c.setNprice(nprice);
				 c.setNtotalprice(ntotalprice);
				 //ע�⣡�����ܸպõ���0
//				 if(c.getNum()==0){
//					 
//				 }
				 //�ŵ����ﳵ
				 carts.put(order_id, c);
			 }else{
//				 c.setNum(c.getNum()+Integer.parseInt(num));
			 }
			 //����map�ŵ�session��
			 request.getSession().setAttribute("Order", carts);
           //��ӳɹ��������ʾ
			 response.getWriter().println("<srcipt>alert('��ӳɹ�')</srcipt>");
			 request.getRequestDispatcher("/myorder.jsp").forward(request, response);
			break;
		case "list":
			//request session applicationContext  ������jspҳ���л�ȡ���ǵ�ֵ
			 List<TOrder> lists=dao.getAll();
        	 request.setAttribute("order", lists);
        	//ת������Ʒ����ҳ
        	 request.getRequestDispatcher("/myorder.jsp").forward(request, response);
			break;
		case "del":
			String id=request.getParameter("nid");
			Map<Integer,TOrderItem> carts1=(Map<Integer, TOrderItem>) request.getSession().getAttribute("Orderitem");
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
