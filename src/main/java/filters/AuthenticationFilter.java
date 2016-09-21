package filters;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;

import app.Employee;

/**
 * Created by Erik on 21-9-2016.
 */
public class AuthenticationFilter implements Filter{

    private ArrayList<Employee> employees;

    public void init(FilterConfig filterConfig){

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    public void destroy() {

    }
}
