package com.krishna.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.protocol.Resultset.Concurrency;

public class database {
	public static Connection getconnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
	}
     return con;
}
}
