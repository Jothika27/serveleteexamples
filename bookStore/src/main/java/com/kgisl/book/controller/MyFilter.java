package com.kgisl.book.controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import java.io.PrintWriter;  
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
 

@WebFilter("/servlet1")
public class MyFilter implements Filter{  
  
    public void init(FilterConfig arg0) throws ServletException {}  
          
    public void doFilter(ServletRequest req, ServletResponse resp,  
            FilterChain chain) throws IOException, ServletException {               
                  
        String password=req.getParameter("password");  
        String name=req.getParameter("name");

        if(password.equals("admin")){  
        chain.doFilter(req, resp);//sends request to next resource  
        }  
        else{  
        String invalid="username or password error!";  
        req.setAttribute("invalid", invalid);
        RequestDispatcher rd=req.getRequestDispatcher("index.jsp");  
        rd.include(req, resp);  
        }  
              
    }  
        public void destroy() {}  
      
    }  