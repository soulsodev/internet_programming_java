import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "SssXml", urlPatterns = "/SssXml")
public class SssXml extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Random random = new Random();
            int n = Integer.parseInt(request.getHeader("XRand-N"));
            StringBuilder textResult = new StringBuilder("<?xml version=\"1.0\"  encoding = \"utf-8\" ?>");

            int j =  random.nextInt(5) + 5;
            textResult.append("<rand>");
            for (int i = 0; i < j; i++) {
                Integer number = random.nextInt(2*n) - n;
                textResult.append("<num>").append(number).append("</num>");
            }
            textResult.append("</rand>");
            Thread.sleep(4000);
            response.setContentType("text/xml");
            response.getWriter().println(textResult);

        } catch (Exception e) {
            response.getWriter().println(e.getMessage());
        }
    }
}
