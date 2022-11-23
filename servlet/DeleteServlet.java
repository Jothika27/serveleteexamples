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


@WebServlet(name = "DeleteServlet", urlPatterns = "/deleteServlet")
public class DeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		Student stu=new Student(id);
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection con=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/7000033050/Documents/userdetails.accdb;openExclusive=false;ignoreCase=true","","");
            PreparedStatement p=con.prepareStatement("Delete from student where id=?");
            p.setInt(1, stu.getId());
            p.executeUpdate();
            p.close();
            con.close();
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		resp.sendRedirect("/");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
