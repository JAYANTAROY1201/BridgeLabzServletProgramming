package com.capgemini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.dto.UserBean;
import com.capgemini.dto.ConnectionPool;


public class JdbcImplementation{


	public UserBean authenticate(String email, String password)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		UserBean bean=null;
		try
		{

			pool = ConnectionPool.getInstance();
			con = pool.getConnectionFromPool();

			String query = "select * from emp where email=? and password=?";

			System.out.println("Query : "+query);


			pstmt =con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			System.out.println("ooo");

			//4. Process the Results returned by SQL Queries
			while(rs.next())
			{
				bean=new UserBean();
				//set the data
		
				bean.setuserName(rs.getString("userName")); 
				bean.setUserEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				
				
			}								
			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally{
			//5. Close ALL JDBC Objects
			try 
			{
				if(rs!=null){
					rs.close();
				}
				pool.returnConnectionToPool(con);

				if(pstmt!=null){
					pstmt.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bean;
		//End of outer try-catch
	}//End of authenticate
	
	
	public static int dataEnrty(String email,String username, String password) throws ClassNotFoundException
	{
		int count=0;
		Connection con=null;
		ConnectionPool pool = null;
		PreparedStatement pstn=null;
		try {
			pool = ConnectionPool.getInstance();
			con = pool.getConnectionFromPool();           
			String query="insert into emp values(?,?,?)";
			pstn=con.prepareStatement(query);
			pstn.setString(1,email);
			pstn.setString(2,username);
			pstn.setString(3,password);
			count=pstn.executeUpdate();						
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{			
				try {	
					pool.returnConnectionToPool(con);
					if(pstn!=null)
					{
						pstn.close();
					}
					
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		return count;
		}	
}
