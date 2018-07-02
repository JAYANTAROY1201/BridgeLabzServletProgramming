package com.capgemini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.dto.UserBean;
import com.capgemini.dto.ConnectionPool;


public class JdbcImplementation implements UserDAO{

    public boolean checkEmail(String email)
    {
    	Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		boolean b=false;
		try
		{
			pool = ConnectionPool.getInstance();
			con = pool.getConnectionFromPool();

			String query = "select * from emp where email=?";

			pstmt =con.prepareStatement(query);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			//4. Process the Results returned by SQL Queries
			if(rs.next())
			{
				b=true;
				System.out.println("email exist");
			}
			else
			{
				b=false;
				System.out.println("email wrong");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
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
		return b;
	}
    
    public boolean checkPassword(String email,String password)
    {
    	Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		boolean b=false;
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
			//4. Process the Results returned by SQL Queries
			if(rs.next())
			{
				b=true;
				System.out.println("pasword exist");
			}
			else
			{
				b= false;
				System.out.println("pasword wrong");

			}
		}
		catch (Exception e) {
			e.printStackTrace();
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
		return b;
	}
	public UserBean setUser(String email, String password)
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

			//4. Process the Results returned by SQL Queries
			while(rs.next())
			{
				bean=new UserBean();
				//set the data
		
				bean.setId(rs.getInt("serial_no"));
				bean.setuserName(rs.getString("user_name")); 
				bean.setUserEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setMobile(rs.getString("mobile"));
				
				
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
	
	
	public int dataEnrty(String email,String user_name, String password,String mobile) 
	{
		int count=0;
		Connection con=null;
		ConnectionPool pool = null;
		PreparedStatement pstn=null;
		try {
			pool = ConnectionPool.getInstance();
			con = pool.getConnectionFromPool();           
			String query="insert into emp(email,user_name,password,mobile) values(?,?,?,?)";
			pstn=con.prepareStatement(query);
			pstn.setString(1,email);
			pstn.setString(2,user_name);
			pstn.setString(3,password);
			pstn.setString(4,mobile);
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
