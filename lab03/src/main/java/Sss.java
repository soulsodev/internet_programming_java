import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Sss extends HttpServlet implements Servlet {
    public Sss() {
        super();
        System.out.println("Sss:constructor");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Sss:init");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Sss:destroy");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("Sss:service:" + req.getMethod());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String task = req.getParameter("task");
        if (task.equals("1")) {
            resp.sendRedirect("http://localhost:8081/lab03_war/Ggg?task=1");
        }


        if (task.equals("3")) {
            resp.sendRedirect("task3.html");
        }

        if (task.equals("4")) {
            resp.sendRedirect(req.getContextPath() + "/Ggg?task=" + req.getParameter("task"));
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String task = req.getParameter("task");
        if (task.equals("2.1")) {
            String firstname = req.getParameter("firstname");
            String lastname = req.getParameter("lastname");
            String password = req.getParameter("password");
            String sex = req.getParameter("sex");
            String press = req.getParameter("press");
            resp.setContentType("text/html");
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<html> " + "<body> "
                    + "<h2>Personal information (Sss)</h2>"
                    + "<br>Sss:doPost:firstname=" + firstname
                    + "<br>Sss:doPost:lastname= " + lastname
                    + "<br>Sss:doPost:password= " + password
                    + "<br>Sss:doPost:sex= " + sex
                    + "<br>Sss:doPost:press= " + press
                    + "</body>" + "</html>");
            printWriter.close();
        }

        //Redirect
        if (task.equals("2.2")) {
            resp.setStatus(307);
            resp.setHeader("Location", req.getContextPath() + "/Ggg?task=" + req.getParameter("task"));
            System.out.println(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        }

        //Forward
        if (task.equals("2.3")) {
            String path = "/Ggg?task=" + req.getParameter("task");
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(req, resp);
        }
    }
}
