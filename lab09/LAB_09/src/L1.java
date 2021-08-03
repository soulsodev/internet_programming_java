import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Locale;

public class L1 implements ServletContextListener, ServletContextAttributeListener,
        HttpSessionListener, HttpSessionAttributeListener {

    public L1() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextListener: Initialized context");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ContextListener: Destroyed context");
    }

    public void sessionCreated(HttpSessionEvent se) {

    }

    public void sessionDestroyed(HttpSessionEvent se) {

    }

    public void attributeAdded(HttpSessionBindingEvent sbe) {

    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {

    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {

    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent sce) {
        System.out.println(sce.getName().toUpperCase(Locale.ROOT) + ":");
        System.out.println("ContextAddListener[key]: " + sce.getName());
        System.out.println("ContextAddListener[value]: " + sce.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent sce) {
        System.out.println(sce.getName().toUpperCase(Locale.ROOT) + ":");
        System.out.println("ContextRemoveListener[key]: " + sce.getName());
        System.out.println("ContextRemoveListener[value]: " + sce.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent sce) {
        System.out.println(sce.getName().toUpperCase(Locale.ROOT) + ":");
        System.out.println("ContextReplaceListener: " + sce.getName());
        System.out.println("ContextReplaceListener: " + sce.getValue());
    }
}
