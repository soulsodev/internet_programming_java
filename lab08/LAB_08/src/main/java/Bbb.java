import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/Bbb")
public class Bbb extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();

        System.out.println("HEADERS:");
        System.out.println(request.getHeader("Header1"));
        System.out.println(request.getHeader("Header2"));
        System.out.println(request.getHeader("Header3"));
        System.out.println("QUERY PARAMETERS:");
        System.out.println(request.getParameter("Param1"));
        System.out.println(request.getParameter("Param2"));
        System.out.println(request.getParameter("Param3"));

        printWriter.println("<html><body>" +
                "Header1 = " + request.getHeader("Header1") + "<br>" +
                "Header2 = " + request.getHeader("Header2") + "<br>" +
                "Header3 = " + request.getHeader("Header3") + "<br>" +

                "Param1 = " + request.getParameter("Param1") + "<br>" +
                "Param2 = " + request.getParameter("Param2") + "<br>" +
                "Param3 = " + request.getParameter("Param3") + "<br>"

        );

        response.addHeader("Bbb_header_1", request.getHeader("Header1"));
        response.addHeader("Bbb_header_2", request.getHeader("Header2"));
        response.addHeader("Bbb_header_3", request.getHeader("Header3"));

        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

    }
}
