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

    final FilterCall func;

    public static FunctionalFilter of(FilterCall func) {
        return new FunctionalFilter(func);
    }

    public FunctionalFilter(FilterCall func) {
        this.func = func;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        if (func.call(request, response)) {
            chain.doFilter(request, response);
        }
    }

    @Override public void init(FilterConfig conf) throws ServletException { }

    @Override public void destroy() { }
}
