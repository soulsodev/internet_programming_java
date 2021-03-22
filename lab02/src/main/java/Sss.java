import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class Sss extends HttpServlet implements Servlet {

    public Sss() {
        super();
        System.out.println("Servlet Sss has been constructed");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Servlet Sss has been initialized");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        super.service(request, response);
        System.out.println("Service");
        try (PrintWriter pw = new PrintWriter(response.getOutputStream())) {
            pw.println("Sss Service: " + request.getMethod());
            pw.println("Sss Server name: " + request.getServerName());
            pw.println("Sss Client IP: " + request.getRemoteHost());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter pw = new PrintWriter(response.getOutputStream())) {
            pw.println("The GET method called");

            Map<String, String[]> params = request.getParameterMap();
            params.forEach((key, val) -> pw.println(key + " = " + val[0]));

            String url = request.getRequestURL().toString();
            if (request.getQueryString() != null) {
                url += "?" + request.getQueryString();
            }
            pw.println(url);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter pw = new PrintWriter(response.getOutputStream())) {
            pw.println("The POST method called");

            Map<String, String[]> params = request.getParameterMap();
            params.forEach((key, val) -> pw.println(key + " = " + val[0]));
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Servlet Sss has been destroyed");
    }

}
