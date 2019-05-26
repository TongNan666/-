package com.gok.shop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gok.shop.pojo.TOrder;
import com.gok.shop.utils.jdbcUtils;

public class OrderDao {
	public List<TOrder> getAll(){
		Connection con=jdbcUtils.getConnection();
		List<TOrder> lists=new ArrayList<>(); 
			try {
				Statement sta=con.createStatement();
				//+((Integer.parseInt(page)-1)*10)+",10"
				ResultSet set=sta.executeQuery("select *from t_order  ");
			    while(set.next()){
			    	TOrder to=new TOrder();
			    	to.setOrder_Id(set.getInt(1));
			    	to.setSsname(set.getString(14));
			    	to.setSsaddress(set.getString(15));
			    	to.setSsphone(set.getString(17));
			    	to.setSmsg(set.getString(11));
			    	lists.add(to);
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
	
	
	public int save( String order_code,String ssname,String ssaddress,String ssphone,String smsg ) {
		Connection con = jdbcUtils.getConnection();
		try {
			Statement sta = con.createStatement();
			return sta.executeUpdate("insert into t_order(order_code,ssname,ssaddress,ssphone,smsg) values( ' "+order_code+ "','"+ssname+ "','"+ssaddress + "','" + ssphone + "','" + smsg +"')");
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


	public TOrder get(String order_code) {
	//	List<TOrder> lists=new ArrayList<>(); 
		TOrder po=null;
        Connection con=jdbcUtils.getConnection();
        try {
			Statement sta=con.createStatement();
			ResultSet set=sta.executeQuery("select * from t_order where order_code="+order_code);
			while(set.next()){
				TOrder to=new TOrder();
				to.setOrder_Id(set.getInt(1));
				to.setOrder_Code(set.getString(2));
		    	to.setSsname(set.getString(14));
		    	to.setSsaddress(set.getString(15));
		    	to.setSsphone(set.getString(17));
		    	to.setSmsg(set.getString(11));
		    	po=to;
			}
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
		
		return po;
	}


	public int saveitem(int code, int nid, int num, float price, float totalprice) {
		Connection con = jdbcUtils.getConnection();
		try {
			Statement sta = con.createStatement();
			return sta.executeUpdate("insert into t_order_item(order_id,nid,ncount,nprice,ntotalprice) values( ' "+code+ "','"+nid+ "','"+num + "','" + price + "','" + totalprice +"')");
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
}
