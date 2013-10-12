package mikaelhg.functional.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@FunctionalInterface
public interface FilterCall {

    boolean call(ServletRequest req, ServletResponse res)
            throws ServletException, IOException;

}
