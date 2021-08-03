import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

@WebServlet(urlPatterns = "/Aaa")
public class Aaa extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<Object, Object> data = new HashMap<>();
        data.put("Param1", request.getParameter("Param1"));
        data.put("Param2", request.getParameter("Param2"));
        data.put("Param3", request.getParameter("Param3"));

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest httpClientReq = HttpRequest.newBuilder()
                .POST(ofFormData(data))
                .uri(URI.create("http://localhost:8081/LAB_08_war_exploded/Bbb"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .setHeader("Header1", request.getHeader("Header1"))
                .setHeader("Header2", request.getHeader("Header2"))
                .setHeader("Header3", request.getHeader("Header3"))
                .build();

        try {
            HttpResponse<String> httpClientResp = httpClient.send(httpClientReq, HttpResponse.BodyHandlers.ofString());
            System.out.println(httpClientResp.body());
            response.getWriter().write(httpClientResp.body() + httpClientResp.headers());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }


    public static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }

}
