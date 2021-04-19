import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class SssHttpClient extends HttpServlet implements Servlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SssHttpClient");

        String params = req.getParameterMap().entrySet().stream()
                .map(e -> String.format("%s=%s", e.getKey(), e.getValue()[0]))
                .collect(Collectors.joining(", ", "[", "]"));
        resp.getWriter().println(req.getMethod() + ": " + params);
    }
}
