package by.tms.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

@WebListener
public class EventListener implements ServletContextListener, HttpSessionIdListener, HttpSessionAttributeListener {
    @Override
    public void sessionIdChanged(HttpSessionEvent httpSessionEvent, String s) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

//    @Override
//    public void attributeAdded(HttpSessionBindingEvent event) {
//        HttpSessionAttributeListener.super.attributeAdded(event);
//    }
//
//    @Override
//    public void attributeRemoved(HttpSessionBindingEvent event) {
//        HttpSessionAttributeListener.super.attributeRemoved(event);
//    }
//
//    @Override
//    public void attributeReplaced(HttpSessionBindingEvent event) {
//        HttpSessionAttributeListener.super.attributeReplaced(event);
//    }
//}
