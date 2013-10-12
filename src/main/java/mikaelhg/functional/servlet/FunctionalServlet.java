package mikaelhg.functional.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class FunctionalServlet extends HttpServlet {

    private final FunctionalServiceCall serviceHandle;

    public static FunctionalServlet of(final FunctionalServiceCall call) {
        return new FunctionalServlet(call);
    }

    public FunctionalServlet(final FunctionalServiceCall serviceHandle) {
        this.serviceHandle = serviceHandle;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        serviceHandle.call(req, res);
    }

}
