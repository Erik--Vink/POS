package filters;

import javax.servlet.*;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.IOException;

/**
 * Created by Erik on 21-9-2016.
 */
public class SessionLifeCycle implements HttpSessionListener{


    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
