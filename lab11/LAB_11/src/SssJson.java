
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "SssJson", urlPatterns = "/SssJson")
public class SssJson extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Random random = new Random();
            int n = Integer.parseInt(request.getHeader("XRand-N"));
            StringBuilder textResult = new StringBuilder();

            int j =  random.nextInt(5) + 5;
            textResult.append("[");
            for (int i = 0; i < j; i++) {
                Integer number = random.nextInt(2*n) - n;
                textResult.append(number).append(i < j -1 ? "," : "");
            }
            textResult.append("]");

            Thread.sleep(2000);

            response.setContentType("application/json");
            response.getWriter().println(textResult);

        } catch (Exception e) {
            response.getWriter().println(e.getMessage());
        }
    }
}
