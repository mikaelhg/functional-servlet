package mikaelhg.functional.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * A functional wrapper for a servlet Filter.
 *
 * Usage:
 *
 * FunctionalFilter.of((req, res) -> {
 *     System.out.println(req.getCharacterEncoding()));
 *     return true;
 * });
 */
public class FunctionalFilter implements javax.servlet.Filter {

    final FunctionalServiceCall serviceHandle;

    public static FunctionalFilter of(FunctionalServiceCall func) {
        return new FunctionalFilter(func);
    }

    public FunctionalFilter(FunctionalServiceCall serviceHandle) {
        this.serviceHandle = serviceHandle;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        if (serviceHandle.call(request, response)) {
            chain.doFilter(request, response);
        }
    }

    @Override public void init(FilterConfig conf) throws ServletException { }

    @Override public void destroy() { }
}
