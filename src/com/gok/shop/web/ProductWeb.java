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

import com.alibaba.fastjson.JSON;
import com.gok.shop.dao.Dao;
import com.gok.shop.dao.ProductDao;
import com.gok.shop.pojo.Product;
import com.gok.shop.pojo.TUser;
import com.sun.org.apache.bcel.internal.generic.D2F;

/**
 * Servlet implementation class ProductWeb
 */
@WebServlet("/ProductWeb")
public class ProductWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProductDao dao=new ProductDao();
       Dao userdao=new Dao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductWeb() {
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
            	  //��Ϊ�ǿ�ܰ����Ƿ�ҳ������ÿ�ζ�Ҫ������������� f12�鿴�����������
            	  		String page=request.getParameter("page");
            	  		List<Product> lists=dao.getAll(page);
            	  		int total=dao.count();
            	  		//����json
            	  		//�ܼ�¼������Ҫ��ѯ���ݣ�count������Ϊ����ֱ������10
            	  		Map<String, Object> map=new HashMap<>();
            	  		//����ת����json��ʽ������
            	  		map.put("total", total);
            	  		map.put("rows", lists);
            	    	//��Ӧjson������Ҫ�ƶ���Ӧͷr
            	    	response.setContentType("application/json;charset=utf-8");
            	        response.getWriter().print(JSON.toJSONString(map));
              }
      			//��ȡ��Ʒ����
              else if("get".equals(m)){
            	  String id=request.getParameter("id");
            	  //��ѯ��Ʒ��Ϣ
            	 Product product=dao.get(id);
            	 request.setAttribute("p", product);
            	 //ת������Ʒ����ҳ
            	 request.getRequestDispatcher("/Product.jsp").forward(request, response);
              }
              //�����Ʒ
              else  if("add".equals(m)) {
        			String nid=request.getParameter("nid");
        			String sname=request.getParameter("sname");
        			String sdescription=request.getParameter("sdescription");
        			String nprice=request.getParameter("nprice");
        			int i=dao.add(nid, sname, sdescription, nprice);
        			if(i>0) {
        				response.sendRedirect("http://localhost:8080/shop/page/productlist.html");
        			}
        			else {
        				response.getWriter().print("���ʧ��");
        			}
        		}
              //ɾ����Ʒ
              else if("del".equals(m)) {
        			int uid = Integer.valueOf(request.getParameter("uid"));
        			int i=dao.delete(uid);
        			System.out.println(i);
        			if(i>0) {
        				response.sendRedirect("http://localhost:8080/shop/page/productlist.html");
        			}
        			else {
        				response.getWriter().print("ɾ��ʧ��");
        			}
        		}
              
            //��ȡ�û�����
              else if("userlist".equals(m)){
              String page=request.getParameter("page");
  	  		List<TUser> lists=userdao.selectUser(page);
  	  		//����json
  	  		//�ܼ�¼������Ҫ��ѯ���ݣ�count������Ϊ����ֱ������10
  	  		Map<String, Object> map=new HashMap<>();
  	  		//����ת����json��ʽ������
  	  	     int total=dao.count();
  	  		map.put("total", total);
  	  		map.put("rows", lists);
  	    	//��Ӧjson������Ҫ�ƶ���Ӧͷr
  	    	response.setContentType("application/json;charset=utf-8");
  	        response.getWriter().print(JSON.toJSONString(map));
              }
              //ɾ���û�
              else if("userdel".equals(m)) {
      			int uid = Integer.valueOf(request.getParameter("uid"));
      			int i=userdao.userdelete(uid);
      			System.out.println(i);
      			if(i>0) {
      				response.sendRedirect("http://localhost:8080/shop/page/userlist.html");
      			}
      			else {
      				response.getWriter().print("ɾ��ʧ��");
      			}
      		}
              //����û�
              else  if("adduser".equals(m)) {
      			String suser=request.getParameter("suser");
      			String ssex=request.getParameter("ssex");
      			String sphone=request.getParameter("sphone");
      			String spwd=request.getParameter("spwd");
      			int i=userdao.addUser(suser, spwd, sphone, ssex);
      			if(i>0) {
      				response.sendRedirect("http://localhost:8080/shop/page/userlist.html");
      			}
      			else {
      				response.getWriter().print("���ʧ��");
      			}
      		}
              //�����û�
              else  if("updateuser".equals(m)) {
      			String suser=request.getParameter("suser");
      			String ssex=request.getParameter("ssex");
      			String sphone=request.getParameter("sphone");
      			String spwd=request.getParameter("spwd");
      			String uid=request.getParameter("uid");
      			int i=userdao.updateUser(suser, spwd, sphone, ssex,uid);
      			if(i>0) {
      				response.sendRedirect("http://localhost:8080/shop/page/userlist.html");
      			}
      			else {
      				response.getWriter().print("�༭ʧ��");
      			}}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
