package com.gok.shop.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.gok.shop.dao.OrderDao;
import com.gok.shop.dao.ProductDao;
import com.gok.shop.pojo.Product;
import com.gok.shop.pojo.TOrder;

import javafx.scene.Parent;

/**
 * Servlet implementation class Order
 */
@WebServlet("/Order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       OrderDao dao=new OrderDao();
       ProductDao prodao=new ProductDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
         String m=request.getParameter("m");
         if("list".equals(m)){
        	 String img=request.getParameter("img");
        	 String order_code=request.getParameter("order_code");
        	 Product product=prodao.getpro(img);
        	 request.setAttribute("p", product);
        	 TOrder  lists=dao.get(order_code);
        	 request.setAttribute("order", lists);
        	 //转发到商品详情页
        	 request.getRequestDispatcher("/order.jsp").forward(request, response);
        	//可以使用fastjson，把对象转成json格式的数据t
//         	String res=JSON.toJSONString(lists);
//         	//相应json数据需要制定响应头r
//         	response.setContentType("application/json;charset=utf-8");
//             response.getWriter().print(res);
         }else if("add".equals(m)){
        	int  code=(int) System.currentTimeMillis();
        	String order_code=String.valueOf(code);
        	int num=Integer.parseInt(request.getParameter("num"));
        	int nid=Integer.parseInt(request.getParameter("nid"));
        	String img=request.getParameter("img");
        	float price=Float.parseFloat(request.getParameter("price"));
        	float totalprice=num*price;
        	 String ssname=request.getParameter("ssname");
        	 String ssaddress=request.getParameter("ssaddress");
        	 String ssphone=request.getParameter("ssphone");
        	 String smsg=request.getParameter("smsg");
        	 int  i  = dao.save(order_code,ssname,ssaddress,ssphone,smsg);
        	 int j=dao.saveitem(code,nid,num,price,totalprice);
        	 if(i>0)  //天转到lsit页面 
     		{
     			response.sendRedirect("http://localhost:8080/shop/Order?m=list&order_code="+order_code+"&img="+img);
     		}else{
     			//提示一下 
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
