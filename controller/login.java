package com.krishna.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.krishna.dbconnection.database;
import com.krishna.model.User;

@WebServlet("/loginform")
public class login extends HttpServlet{
	private String name;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		String myemail=req.getParameter("email1");
		String pass=req.getParameter("pwd");
		try
		{
			Connection con=database.getconnection();
			String query="select * from register where email=? and pwd=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,myemail);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
					{
				User user=new User();
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPass(rs.getString("pwd"));
				HttpSession session1 =req.getSession();
				session1.setAttribute("user_session", user);
				RequestDispatcher rd=req.getRequestDispatcher("profile.jsp");
				rd.forward(req, res);
					}
			else
			{
				res.getWriter().println("<h3 style='color:green'>login failed..</h3>");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.include(req, res);
			}
			
			
		}
		catch(Exception e)
		{
	
			e.printStackTrace();
		}

	}

	private void setCity(String string) {
		// TODO Auto-generated method stub
		
	}

	private void setEmail(String string) {
		// TODO Auto-generated method stub
		
	}

	private void setName(String string) {
		// TODO Auto-generated method stub
		
	}
}


