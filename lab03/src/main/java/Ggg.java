import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Ggg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String task = req.getParameter("task");

        if (task.equals("1")) {
            String param1 = req.getParameter("surname");
            String param2 = req.getParameter("name");
            System.out.println("Ggg:doGet:surname=" + param1);
            System.out.println("Ggg:doGet:name=" + param2);
            resp.setContentType("text/html");
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<html> " +
                    "<body> " +
                    "<h2>Hello from Servlet Ggg!</h2>" +
                    "<br>Ggg:doGet:surname=" + param1 +
                    "<br>Ggg:doGet:name=" + param2 +
                    "<br>Ggg:getRemoteHost: " + req.getRemoteHost() +
                    "<br>Ggg:getServletPath: " + req.getServletPath() +
                    "<br>Ggg:getServerName: " + req.getServerName() +
                    "<br>Ggg:rq.getContextPath: " + req.getContextPath() +
                    "<br>Ggg:getServletName: " + this.getServletName() +
                    "</body>" +
                    "</html>");
            printWriter.close();
        }

        if (task.equals("4")) {
            resp.sendRedirect("task4.html");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String task = req.getParameter("task");
        if (task.equals("2.2")) {
            String firstname = req.getParameter("firstname");
            String lastname = req.getParameter("lastname");
            String password = req.getParameter("password");
            String sex = req.getParameter("sex");
            String press = req.getParameter("press");
            resp.setContentType("text/html");
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<html> " + "<body> "
                    + "<h2>Personal information (Ggg Redirect)</h2>"
                    + "<br>Sss:doPost:firstname=" + firstname
                    + "<br>Sss:doPost:lastname= " + lastname
                    + "<br>Sss:doPost:password= " + password
                    + "<br>Sss:doPost:sex= " + sex
                    + "<br>Sss:doPost:press= " + press
                    + "</body>" + "</html>");
            printWriter.close();
        }

        if (task.equals("2.2")) {
            resp.sendRedirect(req.getContextPath() + "/Ggg?task=" + req.getParameter("task"));
        }

        if (task.equals("2.3")) {
            String firstname = req.getParameter("firstname");
            String lastname = req.getParameter("lastname");
            String password = req.getParameter("password");
            String sex = req.getParameter("sex");
            String press = req.getParameter("press");
            resp.setContentType("text/html");
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<html> " + "<body> "
                    + "<h2>Personal information (Ggg Forward)</h2>"
                    + "<br>Sss:doPost:firstname=" + firstname
                    + "<br>Sss:doPost:lastname= " + lastname
                    + "<br>Sss:doPost:password= " + password
                    + "<br>Sss:doPost:sex= " + sex
                    + "<br>Sss:doPost:press= " + press
                    + "</body>" + "</html>");
            printWriter.close();
        }
    }
}
