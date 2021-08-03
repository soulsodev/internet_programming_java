import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Jsp implements Filter {
    public void destroy() {
        System.out.println("JSP: destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {

        req.setAttribute("jspFilter", "true");
        System.out.println("JSP: doFilter");

        if(req.getParameter("authToken").isEmpty()) {
            HttpServletResponse httpResponse = (HttpServletResponse)resp;
            httpResponse.sendRedirect("login.jsp");
        }

        else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Ccc.jsp" );
            requestDispatcher.forward(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("JSP: init");
    }
}