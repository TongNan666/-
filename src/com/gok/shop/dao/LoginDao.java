package com.gok.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gok.shop.pojo.Login;
import com.gok.shop.pojo.Product;
import com.gok.shop.utils.jdbcUtils;

public class LoginDao {

	private Statement stm = null;
	private ResultSet rs = null;
	//注册插入
	public int insert_prepare(String name, String phone,String password) {
		Connection con=jdbcUtils.getConnection();
		PreparedStatement pst = null;
		int k = 0;
		if (con != null)
			try {
				pst = (PreparedStatement) con.prepareStatement("insert into login values(?,?,?)");
				pst.setString(1, name);
				pst.setString(2, password);
				pst.setString(3, phone);
				k = pst.executeUpdate();
			} catch (SQLException ex) {
				System.out.println("插入失败！");
			}finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return k;
	}
	public ResultSet select(String sql) {
		Connection con=jdbcUtils.getConnection();
		if (stm != null)
			try {
				rs = stm.executeQuery(sql);
			} catch (SQLException ex) {
				System.out.println("查询失败！" + sql);
			}finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return rs;
	}
	
	//查看用户是否存在
		public boolean isExist(String name){
			Connection con=jdbcUtils.getConnection();
			String sql = "select * from login where name='"+name+"'";
			String str=null;
			
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
//				ResultSet rs = select(sql);
				if(rs.next()) {
					str=rs.getString(1);
				}
				if (str==null) {
					return false;
				} else {
					return true;
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

			return false;
		}
	
	//检查密码是否正确
	public boolean ispassword(String name,String password){
		Connection con=jdbcUtils.getConnection();
		String sql="select password from login where name='"+name+"'and "+"password='" +password+"'";
        String str=	null;      
        try {
        	 PreparedStatement ps=con.prepareStatement(sql);
     		 ResultSet rs=ps.executeQuery();
			if(rs.next()){
				str=rs.getString(1);
			}
		     if(password.equals(str)){
		        	return true;
		        }else{
		        	return false;
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
   return false;
	}
	
	//检查状态是否正确
		public boolean isstate(String name ){
			Connection con=jdbcUtils.getConnection();
			String sql="select state from login where name='"+name+"'";
			String str=null;
			String  state="ok";
//	         rs=select(sql);
	        try {
	        	 PreparedStatement ps=con.prepareStatement(sql);
	     		ResultSet rs=ps.executeQuery();
				if(rs.next()){
					str=rs.getString(4);
				}
				 if(state.equals(str)){
			        	return true;
			        }else{
			        	return false;
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
			return false;
	       
		}
		public Login getAll(String name) {
			Connection con=jdbcUtils.getConnection();
			String sql = "select * from login where name='"+name+"'";
			String str=null;
			Login vo=null;
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				 while(rs.next()){
				    	Login lo=new Login();
				    	lo.setLoginid(rs.getString(1));
				    	lo.setName(rs.getString(2));
				    	lo.setPassword(rs.getString(3));
				    	lo.setPhone(rs.getString(4));
				    	lo.setState(rs.getString(5));
				    	vo=lo;
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
			return vo;
}
}
