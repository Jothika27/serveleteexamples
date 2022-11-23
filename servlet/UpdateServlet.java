package com.sony.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateServlet", urlPatterns = "/updateServlet")
public class UpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    int id=Integer.parseInt(req.getParameter("id"));
	    String name=req.getParameter("name");
	    float physics=Float.parseFloat(req.getParameter("physics"));
	    float maths=Float.parseFloat(req.getParameter("maths"));
	    float chemistry=Float.parseFloat(req.getParameter("chemistry"));
	    Student stu=new Student(id,name,physics,maths,chemistry);
	    try {
	    	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection con=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/7000033050/Documents/userdetails.accdb;openExclusive=false;ignoreCase=true","","");
			PreparedStatement st = con
	                   .prepareStatement("Update student set name=?,physics=?,maths=?,chemistry=? where id=?");
			st.setString(1, stu.getName());
			st.setFloat(2, physics);
			st.setFloat(3, maths);
			st.setFloat(4, chemistry);
			st.setInt(5,stu.getId());
			st.executeUpdate();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("/");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}




