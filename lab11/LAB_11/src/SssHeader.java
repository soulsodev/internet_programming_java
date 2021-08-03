import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SssHeader", urlPatterns = "/SssHeader")
public class SssHeader extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer x = Integer.parseInt(request.getHeader("Value-x"));
            Integer y = Integer.parseInt(request.getHeader("Value-y"));
            int z = x + y;
            Thread.sleep(1000);
            response.setHeader("Value-z", Integer.toString(z));
        } catch (Exception e) {
            response.getWriter().println(e.getMessage());
        }
    }
}
