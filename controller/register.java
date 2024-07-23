package com.krishna.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.krishna.dbconnection.database;

@WebServlet("/regpage")	
public class register extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String name=req.getParameter("name1");
		String myemail=req.getParameter("email1");
		String pass=req.getParameter("pwd");
		String city=req.getParameter("city1");
		try {
			Connection con=database.getconnection();
			String query="insert into register(name,email,pwd,city) values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,myemail);
			ps.setString(3,pass);
			ps.setString(4,city);
			int count=ps.executeUpdate();
			if(count>0)
			{
				System.out.println("<h3 style='color:green'>Registered successfully..</h3>");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.include(req, res);
		
			}
			else
			{
				System.out.println("<h3 style='color:green'>Registered fail.....</h3>");
				RequestDispatcher rd=req.getRequestDispatcher("registeration.jsp");
				rd.include(req, res);
		
			}
			
			
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
		
	

	}
}
