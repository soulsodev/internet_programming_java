import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GggForward extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String task = req.getParameter("task");

        if (task.equals("1")) {
            String param1 = req.getParameter("surname");
            String param2 = req.getParameter("name");
            System.out.println("GggForward:doGet:surname=" + param1);
            System.out.println("GggForward:doGet:name=" + param2);
            resp.setContentType("text/html");
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<html> " +
                    "<body> " +
                    "<h2>Hello from Servlet GggForward!</h2>" +
                    "<br>GggForward:doGet:surname=" + param1 +
                    "<br>GggForward:doGet:name=" + param2 +
                    "<br>GggForward:getRemoteHost: " + req.getRemoteHost() +
                    "<br>GggForward:getServletPath: " + req.getServletPath() +
                    "<br>GggForward:getServerName: " + req.getServerName() +
                    "<br>GggForward:rq.getContextPath: " + req.getContextPath() +
                    "<br>GggForward:getServletName: " + this.getServletName() +
                    "</body>" +
                    "</html>");
            printWriter.close();
        }

        if (task.equals("4")) {
            String path = "/task4_forward.html";
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(req, resp);
        }

    }
}
