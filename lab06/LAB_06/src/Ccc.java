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
        CBean cb = new CBean();
        ServletContext sc = getServletContext();
        sc.setAttribute("value1",cb.getValue1());
        sc.setAttribute("value2",cb.getValue2());
        sc.setAttribute("value3",cb.getValue3());
        sc.setAttribute("atrCBean", cb);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        CBean cBean;

        if(request.getParameter("CBean").equals("old")) {
            cBean = (CBean)servletContext.getAttribute("atrCBean");
            System.out.println("Using old CBean");
        } else {
            cBean = new CBean();
            System.out.println("Using new CBean");

        }

        if(!request.getParameter("value1").isEmpty()) {
            System.out.println("new value1");
            cBean.setValue1(request.getParameter("value1"));
            servletContext.setAttribute("value1",request.getParameter("value1"));
        }  else {
            cBean.setValue1((String)servletContext.getAttribute("value1"));
        }

        if(!request.getParameter("value2").isEmpty()){
            System.out.println("new value2");
            cBean.setValue2(request.getParameter("value2"));
            servletContext.setAttribute("value2",request.getParameter("value2"));
        } else {
            cBean.setValue2((String) servletContext.getAttribute("value2"));
        }

        if(!request.getParameter("value3").isEmpty()){
            System.out.println("new value3");
            cBean.setValue3(request.getParameter("value3"));
            servletContext.setAttribute("value3",request.getParameter("value3"));
        } else {
            cBean.setValue3((String) servletContext.getAttribute("value3"));
        }

        servletContext.setAttribute("atrCBean", cBean);

        request.setAttribute("value1", cBean.getValue1());
        request.setAttribute("value2", cBean.getValue2());
        request.setAttribute("value3", cBean.getValue3());
        request.getRequestDispatcher("/Ccc.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        CBean cBean;

        if(request.getParameter("CBean").equals("old")) {
            cBean = (CBean)servletContext.getAttribute("atrCBean");
            System.out.println("Using old CBean");
        } else {
            cBean = new CBean();
            System.out.println("Using new CBean");

        }

        if(!request.getParameter("value1").isEmpty()) {
            System.out.println("new value1");
            cBean.setValue1(request.getParameter("value1"));
            servletContext.setAttribute("value1",request.getParameter("value1"));
        }  else {
            cBean.setValue1((String)servletContext.getAttribute("value1"));
        }

        if(!request.getParameter("value2").isEmpty()){
            System.out.println("new value2");
            cBean.setValue2(request.getParameter("value2"));
            servletContext.setAttribute("value2",request.getParameter("value2"));
        } else {
            cBean.setValue2((String) servletContext.getAttribute("value2"));
        }

        if(!request.getParameter("value3").isEmpty()){
            System.out.println("new value3");
            cBean.setValue3(request.getParameter("value3"));
            servletContext.setAttribute("value3",request.getParameter("value3"));
        } else {
            cBean.setValue3((String) servletContext.getAttribute("value3"));
        }

        servletContext.setAttribute("artCBean", cBean);

        request.setAttribute("value1", cBean.getValue1());
        request.setAttribute("value2", cBean.getValue2());
        request.setAttribute("value3", cBean.getValue3());
        request.getRequestDispatcher("/Ccc.jsp").forward(request,response);
    }



}
