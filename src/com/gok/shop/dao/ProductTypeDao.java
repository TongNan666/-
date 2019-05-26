package com.gok.shop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gok.shop.pojo.ProductTypeVo;
import com.gok.shop.utils.jdbcUtils;


public class ProductTypeDao {

	public List<ProductTypeVo> treelist() {
     //��ȡ���з���
		//�Ȼ�ȡһ������
		 Connection con=jdbcUtils.getConnection();
		 List<ProductTypeVo> lists=new ArrayList<>();
		try {
			Statement sta=con.createStatement();
			ResultSet set=sta.executeQuery("select * from product_type where pid =0");
			while(set.next()){
			ProductTypeVo vo=new ProductTypeVo(set.getInt(1),set.getString(2));
		   lists.add(vo);
		}
			//���Ҷ�������
			for (ProductTypeVo productTypeVo : lists) {
				ResultSet set1=sta.executeQuery("select * from product_type where pid ="+productTypeVo.getId());
				 List<ProductTypeVo> twochild=new ArrayList<>();
					while(set1.next()){
					ProductTypeVo vo=new ProductTypeVo(set1.getInt(1),set1.getString(2));
					twochild.add(vo);
				}
   //�Ѳ�ѯ�����Ķ����������ø�һ������
					productTypeVo.setChildren(twochild);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lists;
	}

	public int save(String pid, String name) {
		Connection con = jdbcUtils.getConnection();
		try {
			Statement sta = con.createStatement();
			return sta.executeUpdate("insert into product_type values(null,'" + name + "'," + pid + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	
	}

	public List<ProductTypeVo> getCateByid(String pid) {
       
		 Connection con=jdbcUtils.getConnection();
		 List<ProductTypeVo> lists=new ArrayList<>();
		try{
			Statement sta=con.createStatement();
			ResultSet set=sta.executeQuery("select * from product_type where pid ="+pid);
			while(set.next()){
			ProductTypeVo vo=new ProductTypeVo(set.getInt(1),set.getString(2));
		   lists.add(vo);
		}
		} catch (Exception e) {
	         }finally{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		return lists;
	}

	public int delete(String id) {
		 Connection con=jdbcUtils.getConnection();
		 try {
			Statement sta=con.createStatement();
			 int set=sta.executeUpdate("delete from product_type where id="+id);
			 return set;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				 
		return 0;
	}
}