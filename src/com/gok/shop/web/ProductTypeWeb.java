package com.gok.shop.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.gok.shop.dao.ProductTypeDao;
import com.gok.shop.pojo.ProductTypeVo;

/**
 * Servlet implementation class ProductTypeWeb
 */
@WebServlet("/ProductTypeWeb")
public class ProductTypeWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProductTypeDao productTypeDao=new ProductTypeDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductTypeWeb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
		String m=request.getParameter("m");
    if("treelist".equals(m)){
    	List<ProductTypeVo> lists=productTypeDao.treelist();
    	//前端需要json数据
    	//可以使用fastjson，把对象转成json格式的数据t
    	String res=JSON.toJSONString(lists);
    	//相应json数据需要制定响应头r
    	response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(res);
        //添加
    } else if ("add".equals(m)) {
		//获取参数  pid name
		String pid = request.getParameter("pid");
		String name = request.getParameter("name");
		
		int  i  = productTypeDao.save(pid,name);
		if(i>0)  //天转到lsit页面 
		{
			response.sendRedirect("http://localhost:8080/shop/producttype2.html");
		}else{
			//提示一下 
		}
		//删除
    }else if("del".equals(m)){
    	//获取参数Pid
    	String id=request.getParameter("id");
    	//删除pid
    	int i=productTypeDao.delete(id);
    	if(i>0){  //删除成功 跳转到list页面
    		response.sendRedirect("http://localhost:8080/shop/producttype2.html");
    	}else{
    		//提示一下
    	}
    	
    	
    }else if("get1Cate".equals(m)){
    	//这里返回json数据
    	//根据不同的父类分类去对应的子分类
    	String pid=request.getParameter("pid");
    	List<ProductTypeVo> lists=productTypeDao.getCateByid(pid);
    	//可以使用fastjson，把对象转成json格式的数据t
    	String res=JSON.toJSONString(lists);
    	//相应json数据需要制定响应头r
    	response.setContentType("application/json;charset=utf-8");
    	//相应一下
    	response.getWriter().println(res);
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
