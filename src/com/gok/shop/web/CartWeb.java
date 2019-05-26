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
			//获取商品Id和数量
			 String nid=request.getParameter("nid");
			 String num=request.getParameter("num");
			 String name=request.getParameter("name");
			 String img=request.getParameter("img");
			 String price=request.getParameter("price");
			 //判断数量是否合理
			 //从session获取购物车里的Map
			 Map<String,Cart> carts=(Map<String, Cart>) request.getSession().getAttribute("cart");
			//刚进来map为空需要先创建
			 if(carts==null){
			 carts=new HashMap<>();
			 }
			 //先判断该商品有没有
			 Cart c=carts.get(nid);
			 if(c==null){    //没有就创建一个
				 c=new Cart();
				 //设置信息
				 c.setNid(Integer.parseInt(nid));
				 c.setName(name);
				 c.setImg(img);
				 c.setNum(Integer.parseInt(num));
				 c.setPrice(price);
				 //注意！！可能刚好等于0
//				 if(c.getNum()==0){
//					 
//				 }
				 //放到购物车
				 carts.put(nid, c);
			 }else{
				 c.setNum(c.getNum()+Integer.parseInt(num));
			 }
			 //最后把map放到session中
			 request.getSession().setAttribute("cart", carts);
           //添加成功后给个提示
			 response.getWriter().println("<srcipt>alert('添加成功')</srcipt>");
			 request.getRequestDispatcher("/myshop.jsp").forward(request, response);
			break;
		case "list":
			//request session applicationContext  可以在jsp页面中获取他们的值
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
