
import java.net.URI;
import java.net.http.HttpClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Calendar;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import static javax.swing.UIManager.put;


@WebServlet(name = "Jjj", urlPatterns = "/Jjj")
public class Jjj extends HttpServlet {
    private String getDayTime(int hour) {
        String message;
        if (hour >= 0 && hour < 6) {
            message = "night";
        } else if (hour >= 6 && hour < 12) {
            message = "morning";
        } else if (hour >= 12 && hour < 18) {
            message = "afternoon";
        } else {
            message = "evening";
        }
        return message;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String greeting = getDayTime(hour);
        String pageJSP = greeting + ".jsp";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/LAB_04_war_exploded/" + pageJSP))
                .build();

        try {
            HttpResponse<String> response1 = client.send(request1, HttpResponse.BodyHandlers.ofString());
            System.out.println(response1.body());
            response.getWriter().write(response1.body());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String greeting = getDayTime(hour);
        String pageJSP = greeting + ".jsp";

        var values = new HashMap<String, String>() {{
            put("name", "John Doe");
            put("occupation", "gardener");
        }};

        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(values);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest httpClientReq = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create("http://localhost:8081/LAB_04_war_exploded/" + pageJSP))
                .build();

        try {
            HttpResponse<String> httpClientResp = client.send(httpClientReq,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(httpClientResp.body());
            response.getWriter().write(httpClientResp.body());


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}