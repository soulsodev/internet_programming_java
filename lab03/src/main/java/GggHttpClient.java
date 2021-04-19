import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class GggHttpClient extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("GggHttpClient");

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String params = request.getParameterMap().entrySet().stream()
                    .map(e -> String.format("%s=%s", e.getKey(), e.getValue()[0]))
                    .collect(Collectors.joining("&", "?", ""));
            HttpUriRequest req;
            if (request.getMethod().equals("post")) {
                req = new HttpPost("http://localhost:8081/lab03_war/SssHttpClient" + params);
            } else {
                req = new HttpGet("http://localhost:8081/lab03_war/SssHttpClient" + params);
            }

            try (CloseableHttpResponse resp = httpClient.execute(req)) {
                response.getWriter().write(IOUtils.toString(resp.getEntity().getContent()));
                EntityUtils.consume(resp.getEntity());
            }

        }
    }
}
