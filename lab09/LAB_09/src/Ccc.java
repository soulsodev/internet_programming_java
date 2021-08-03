import JSP.CBean;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Ccc", urlPatterns = "/Ccc")
public class Ccc extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        CBean cBean = new CBean();

        if(!request.getParameter("value1").isEmpty()) {
            cBean.setValue1(request.getParameter("value1"));
            servletContext.setAttribute("value1",request.getParameter("value1"));
        }  else {
            cBean.setValue1((String)servletContext.getAttribute("value1"));
        }

        if(!request.getParameter("value2").isEmpty()){
            cBean.setValue2(request.getParameter("value2"));
            servletContext.setAttribute("value2", request.getParameter("value2"));
        } else {
            cBean.setValue2((String) servletContext.getAttribute("value2"));
        }

        if(!request.getParameter("value3").isEmpty()){
            cBean.setValue3(request.getParameter("value3"));
            servletContext.setAttribute("value3",request.getParameter("value3"));
        } else {
            cBean.setValue3((String) servletContext.getAttribute("value3"));
        }

        response.getWriter().write(
                cBean.toString()
        );
    }
}
