import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = {"/welcome"}, loadOnStartup = 1)
public class DemoServlet extends HttpServlet {

    /**
     * 静态变量，可能发生线程安全问题
     */
    public static String name = "Hello";

    /**
     * 实例变量，可能发生线程安全问题
     */
    private int i;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Servlet初始化");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("%s：%s[%s]\n", Thread.currentThread().getName(), i, format.format(new Date()));
        i++;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s：%s[%s]\n", Thread.currentThread().getName(), i, format.format(new Date()));
        resp.getWriter().println("<html><body><h1>" + i + "</h1></body></html>");
    }
}
