import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class L2 implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public L2() {
    }

    public void contextInitialized(ServletContextEvent sce) {

    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

    public void sessionCreated(HttpSessionEvent se) {

    }

    public void sessionDestroyed(HttpSessionEvent se) {    }

    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println("SESSION ID: " + sbe.getSession().getId());
        System.out.println("SessionAddedListener[id]: " + sbe.getSession().getId());
        System.out.println("SessionAddedListener[key]: " + sbe.getName());
        System.out.println("SessionAddedListener[value]: " + sbe.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        System.out.println("SESSION ID: " + sbe.getSession().getId());
        System.out.println("SessionRemoveListener: " + sbe.getSession().getId());
        System.out.println("SessionRemoveListener: " + sbe.getName());
        System.out.println("SessionRemoveListener: " + sbe.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        System.out.println("SESSION ID: " + sbe.getSession().getId());
        System.out.println("SessionReplaceListener: " + sbe.getSession().getId());
        System.out.println("SessionReplaceListener: " + sbe.getName());
        System.out.println("SessionReplaceListener: " + sbe.getValue());
    }
}
