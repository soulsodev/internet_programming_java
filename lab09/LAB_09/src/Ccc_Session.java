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

@WebServlet(name = "Ccc_Session", urlPatterns = "/Ccc_Session")
public class Ccc_Session extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession requestSession = request.getSession();
        String requestSessionId = requestSession.getId();

        CBean cBean;

        if (request.getParameter("CBean").equals("old")) {
            cBean = (CBean) requestSession.getAttribute(requestSessionId);
        } else {
            cBean = new CBean();
        }

        if (!request.getParameter("value1").isEmpty()) {
            cBean.setValue1(request.getParameter("value1"));
            requestSession.setAttribute("value1", request.getParameter("value1"));

        } else {
            cBean.setValue1((String) requestSession.getAttribute("value1"));
        }

        if (!request.getParameter("value2").isEmpty()) {
            cBean.setValue2(request.getParameter("value2"));
            requestSession.setAttribute("value2", request.getParameter("value2"));

        } else {
            cBean.setValue2((String) requestSession.getAttribute("value2"));
        }

        if (!request.getParameter("value3").isEmpty()) {
            cBean.setValue3(request.getParameter("value3"));
            requestSession.setAttribute("value3", request.getParameter("value3"));
        } else {
            cBean.setValue3((String) requestSession.getAttribute("value3"));
        }

        requestSession.setAttribute(requestSessionId, cBean);

        if (requestSession.getAttribute(requestSessionId) == null) {
            requestSession.setAttribute(requestSessionId, cBean);
        }

    }


}
