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
			//获取商品Id和数量
			int order_id=Integer.parseInt(request.getParameter("order_id"));
			int ncount=Integer.parseInt(request.getParameter("ncount"));
			float nprice=Float.parseFloat(request.getParameter("nprice"));
			float ntotalprice=Float.parseFloat(request.getParameter("ntotalprice"));
			 String ssname=request.getParameter("ssname");
			 String ssaddress=request.getParameter("ssaddress");
			 String ssphone=request.getParameter("ssphone");
			 String smsg=request.getParameter("smsg");
			 //判断数量是否合理
			 //从session获取购物车里的Map
			 Map<Integer,TOrderItem> carts=(Map<Integer, TOrderItem>) request.getSession().getAttribute("Orderitem");
			//刚进来map为空需要先创建
			 if(carts==null){
			 carts=new HashMap<>();
			 }
			 //先判断该商品有没有
			 TOrderItem c=carts.get(order_id);
			 if(c==null){    //没有就创建一个
				 c=new TOrderItem();
				 //设置信息
				 c.setNcount(ncount);
				 c.setNprice(nprice);
				 c.setNtotalprice(ntotalprice);
				 //注意！！可能刚好等于0
//				 if(c.getNum()==0){
//					 
//				 }
				 //放到购物车
				 carts.put(order_id, c);
			 }else{
//				 c.setNum(c.getNum()+Integer.parseInt(num));
			 }
			 //最后把map放到session中
			 request.getSession().setAttribute("Order", carts);
           //添加成功后给个提示
			 response.getWriter().println("<srcipt>alert('添加成功')</srcipt>");
			 request.getRequestDispatcher("/myorder.jsp").forward(request, response);
			break;
		case "list":
			//request session applicationContext  可以在jsp页面中获取他们的值
			 List<TOrder> lists=dao.getAll();
        	 request.setAttribute("order", lists);
        	//转发到商品详情页
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
