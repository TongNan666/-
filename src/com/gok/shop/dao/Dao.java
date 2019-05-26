package com.gok.shop.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.gok.shop.pojo.TUser;
import com.gok.shop.utils.jdbcUtils;

public class Dao {
		Statement st =null;
		 PreparedStatement ps=null;
		 ResultSet rs =null;
		 Connection con=null;
		 int a=1;
		int flg;
			 public void addpeople(String name,String pswd) {
				 Connection con=jdbcUtils.getConnection();
					String sql="insert into t_user values(?,?)";
				
					try {
						ps=con.prepareStatement(sql);
						ps.setString(1, name);
						ps.setString(2, pswd);
				
						int i =ps.executeUpdate();
						if(i>0) {
						
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				public int userdelete(int  uid) {
					String sql=("delete from t_user where uid="+uid);
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
				public List<TUser> selectUser(String page){
					List<TUser> list=new ArrayList<>();
					Connection con=jdbcUtils.getConnection();
					Statement sta;
					try {
						sta = con.createStatement();
						ResultSet res=sta.executeQuery("select * from t_user limit "+((Integer.parseInt(page)-1)*10)+",10");
					while(res.next()) {
						TUser user=new TUser();
						user.setUid(res.getInt(1));
						user.setSname(res.getString(4));
						user.setSpwd(res.getString(3));
						user.setSsex(res.getString(5));
						user.setSphone(res.getString(8));
						list.add(user);
					}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return list;
					
				}
				 public int addUser(String sname,String spwd,String sphone,String ssex) {
					 Connection con=jdbcUtils.getConnection();
						String sql="insert into t_user(sname,spwd,ssex,sphone) values(?,?,?,?)";
						int i=0;
						try {
							ps=con.prepareStatement(sql);
							ps.setString(1, sname);
							ps.setString(2, spwd);
							ps.setString(3, ssex);
							ps.setString(4, sphone);
							 i =ps.executeUpdate();
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return i;
					} 
				 public int updateUser(String sname,String spwd,String sphone,String ssex,String uid) {
						 Connection con=jdbcUtils.getConnection();
							String sql="update t_user SET sname=?,spwd=?,ssex=?,sphone=? where uid=?";
							int i=0;
							try {
								ps=con.prepareStatement(sql);
								ps.setString(1, sname);
								ps.setString(2, spwd);
								ps.setString(3, sphone);
								ps.setString(4, ssex);
								ps.setString(5, uid);
								 i =ps.executeUpdate();
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return i;
						}
			 public int selectSinglepeople(String name,String pswd) {
				 Connection con=jdbcUtils.getConnection();
					String sql="select * from t_user where name=?and password=?";
					
					  try {
						ps=con.prepareStatement(sql);
						ps.setString(1, name);
						ps.setString(2, pswd);
						rs =ps.executeQuery();
						if(rs.next()) {
//							
							a=0;
						}
						else {
							a=1;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return a;
			 }
					
						
					
			 public static void Close(ResultSet rs,Statement st,Connection conn) {
				 //为了避免空指针，先判断是否为空 
				 
					 try {
						 if(rs!=null) {
						rs.close();
						}
						 if(st!=null) {
							 st.close();
						}
						 if(conn!=null) {
							 conn.close();
						 }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 }
			 
			

			 
			 public TUser getAllMessage(String username) {

					Connection con = null;
					Statement sta = null;
					ResultSet set = null;
					try {
						con = jdbcUtils.getConnection();
						sta = con.createStatement();
						String sql = "select uid,spwd,sname,ssex,semail,sphone,saddress from t_user where username='"
								+ username + "'";
						// System.out.println(sql);
						set = sta.executeQuery(sql);

						while (set.next()) {
							TUser user = new TUser(set.getInt(1), set.getString(2), set.getString(3), set.getString(4),
									set.getString(5),  set.getString(6), set.getString(7));
							return user;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						try {
							con.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					return null;
				}
			 
			
	}
