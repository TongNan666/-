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
    	//ǰ����Ҫjson����
    	//����ʹ��fastjson���Ѷ���ת��json��ʽ������t
    	String res=JSON.toJSONString(lists);
    	//��Ӧjson������Ҫ�ƶ���Ӧͷr
    	response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(res);
        //���
    } else if ("add".equals(m)) {
		//��ȡ����  pid name
		String pid = request.getParameter("pid");
		String name = request.getParameter("name");
		
		int  i  = productTypeDao.save(pid,name);
		if(i>0)  //��ת��lsitҳ�� 
		{
			response.sendRedirect("http://localhost:8080/shop/producttype2.html");
		}else{
			//��ʾһ�� 
		}
		//ɾ��
    }else if("del".equals(m)){
    	//��ȡ����Pid
    	String id=request.getParameter("id");
    	//ɾ��pid
    	int i=productTypeDao.delete(id);
    	if(i>0){  //ɾ���ɹ� ��ת��listҳ��
    		response.sendRedirect("http://localhost:8080/shop/producttype2.html");
    	}else{
    		//��ʾһ��
    	}
    	
    	
    }else if("get1Cate".equals(m)){
    	//���ﷵ��json����
    	//���ݲ�ͬ�ĸ������ȥ��Ӧ���ӷ���
    	String pid=request.getParameter("pid");
    	List<ProductTypeVo> lists=productTypeDao.getCateByid(pid);
    	//����ʹ��fastjson���Ѷ���ת��json��ʽ������t
    	String res=JSON.toJSONString(lists);
    	//��Ӧjson������Ҫ�ƶ���Ӧͷr
    	response.setContentType("application/json;charset=utf-8");
    	//��Ӧһ��
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
