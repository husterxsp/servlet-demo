import javax.servlet.*;
import javax.servlet.http.*;

public class DemoServ extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        String name = req.getParameter("name");
        pw.println("Welcome " + name);
    }
}
