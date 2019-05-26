package com.gok.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gok.shop.pojo.Product;
import com.gok.shop.utils.jdbcUtils;


public class ProductDao {
public List<Product> getAll(String page){
	Connection con=jdbcUtils.getConnection();
	List<Product> lists=new ArrayList<>(); 
		try {
			Statement sta=con.createStatement();
			//+((Integer.parseInt(page)-1)*10)+",10"
			ResultSet set=sta.executeQuery("select *from product limit "+((Integer.parseInt(page)-1)*10)+",10");
		    while(set.next()){
		    	Product vo=new Product();
		    	vo.setNid(set.getInt(1)); 
		    	vo.setSname(set.getString(2));
		    	vo.setSdescription(set.getString(3));
		    	vo.setNprice(set.getFloat(4));
		    	vo.setSimg("<img src="+set.getString(5)+" '' "+"width=100px,height=100px>" );
		    	lists.add(vo);
		    }
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	
	
	return lists;
	
}

public Product get(String id) {
	Connection con=jdbcUtils.getConnection();
Product pro = null;
		try {
			Statement sta=con.createStatement();
			//+((Integer.parseInt(page)-1)*10)+",10"
			ResultSet set=sta.executeQuery("select *from product where nid= "+id);
		    while(set.next()){
		    	Product vo=new Product();
		    	vo.setNid(set.getInt(1)); 
		    	vo.setSname(set.getString(2));
		    	vo.setSdescription(set.getString(3));
		    	vo.setNprice(set.getFloat(4));
		    	vo.setSimg(set.getString(5));
		    	vo.setSmctag(set.getInt(6));
		    	pro=vo;
		    }
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	return pro;
}

public int count() {
	Connection con=jdbcUtils.getConnection();
	ResultSet res;
	int count=0;
	try {
		Statement sta=con.createStatement();
		 res=sta.executeQuery("select * from product");
		 if(res.next()) {
        res.last();
       count=res.getRow();
		 }
	}
      catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return count;

}

public int add(String nid, String sname, String sdescription, String nprice) {
	Connection con=jdbcUtils.getConnection();
	String sql="insert into product(nid,sname,sdescription,nprice) values(?,?,?,?)";
	int i=0;
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, nid);
		ps.setString(2, sname);
		ps.setString(3, sdescription);
		ps.setString(4, nprice);
		 i =ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}

public int delete(int uid) {
	String sql=("delete from product where uid="+uid);
	int i=0;
	Connection con= jdbcUtils.getConnection();
	try {
		Statement ps= con.createStatement();
		i= ps.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}

public Product getpro(String img) {
	Connection con=jdbcUtils.getConnection();
	Product pro = null;
			try {
				Statement sta=con.createStatement();
				//+((Integer.parseInt(page)-1)*10)+",10"
				ResultSet set=sta.executeQuery("select *from product where simg= '"+img+"'");
			    while(set.next()){
			    	Product vo=new Product();
			    	vo.setNid(set.getInt(1)); 
			    	vo.setSname(set.getString(2));
			    	vo.setSdescription(set.getString(3));
			    	vo.setNprice(set.getFloat(4));
			    	vo.setSimg(set.getString(5));
			    	vo.setSmctag(set.getInt(6));
			    	pro=vo;
			    }
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		return pro;
	}
}
