import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HomeServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("DO get Called");
        // System.out.println(req.getParameter("uname"));
        // System.out.println(req.getParameter("password"));
        RequestDispatcher dispatcher = req.getRequestDispatcher("ForwardServlet");
        dispatcher.forward(req,resp);
    }
}