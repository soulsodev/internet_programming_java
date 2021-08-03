import javax.servlet.*;
import java.io.IOException;

public class F1 implements Filter {
    public void destroy() {
        System.out.println("F1: destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {

        if(req.getParameter("value3").isEmpty()) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/error.jsp" );
            requestDispatcher.forward(req, resp);
        }

        System.out.println("F1: doFilter");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("F1: init");
    }
}