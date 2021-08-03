import javax.servlet.*;
import java.io.IOException;

public class F2 implements Filter {
    public void destroy() {
        System.out.println("F2: destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {

        System.out.println("F2: doFilter");
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("F2: init");
    }
}