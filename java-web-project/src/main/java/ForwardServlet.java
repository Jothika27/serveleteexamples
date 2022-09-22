import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" forwardservlet DO post Called");
        System.out.println(req.getParameter("uname"));
        System.out.println(req.getParameter("password"));
        ServletConfig config=getServletConfig();  
        String driver=config.getInitParameter("driver"); 
        System.out.println(driver);
    }

}