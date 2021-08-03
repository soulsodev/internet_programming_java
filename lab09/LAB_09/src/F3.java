import javax.servlet.*;
import java.io.IOException;

public class F3 implements Filter {
    public void destroy() {
        System.out.println("F3: destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {

        System.out.println("F3: doFilter");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Ccc" );
        requestDispatcher.forward(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("F3: init");
    }
}