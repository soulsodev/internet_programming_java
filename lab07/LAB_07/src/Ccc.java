import JSP.CBean;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "Ccc", urlPatterns = "/Ccc")
public class Ccc extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        CBean cb = new CBean();
        ServletContext sc = getServletContext();
        sc.setAttribute("value1", cb.getValue1());
        sc.setAttribute("value2", cb.getValue2());
        sc.setAttribute("value3", cb.getValue3());
        sc.setAttribute("atrCBean", cb);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession requestSession = request.getSession();
        String requestSessionId = requestSession.getId();

        CBean cBean;

        if (request.getParameter("CBean").equals("old")) {
            cBean = (CBean) requestSession.getAttribute(requestSessionId);
            System.out.println("Using old CBean");
        } else {
            cBean = new CBean();
            System.out.println("Using new CBean");

        }

        if (!request.getParameter("value1").isEmpty()) {
            System.out.println("new value1");
            cBean.setValue1(request.getParameter("value1"));
            requestSession.setAttribute("value1", request.getParameter("value1"));

        } else {
            System.out.println("Using value1 from session");
            System.out.println("value1 is: " + requestSession.getAttribute("value1"));
            cBean.setValue1((String) requestSession.getAttribute("value1"));

        }

        if (!request.getParameter("value2").isEmpty()) {
            System.out.println("new value2");
            cBean.setValue2(request.getParameter("value2"));
            requestSession.setAttribute("value2", request.getParameter("value2"));

        } else {
            System.out.println("Using value2 from session");
            cBean.setValue2((String) requestSession.getAttribute("value2"));
        }

        if (!request.getParameter("value3").isEmpty()) {
            System.out.println("new value3");

            cBean.setValue3(request.getParameter("value3"));
            requestSession.setAttribute("value3", request.getParameter("value3"));
        } else {
            System.out.println("Using value3 from session");
            cBean.setValue3((String) requestSession.getAttribute("value3"));
        }

        requestSession.setAttribute(requestSessionId, cBean);

        if (requestSession.getAttribute(requestSessionId) == null) {
            System.out.println("SESSION CREATED: " + requestSessionId);
            requestSession.setAttribute(requestSessionId, cBean);
        }

        request.setAttribute("value1", cBean.getValue1());
        request.setAttribute("value2", cBean.getValue2());
        request.setAttribute("value3", cBean.getValue3());
        request.getRequestDispatcher("/Ccc.jsp").forward(request, response);
    }


}
