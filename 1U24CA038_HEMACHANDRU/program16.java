// Practical 16: Servlet redirect and forward
//   InitialServlet -> /initial : ?action=redirect  -> sendRedirect
//                                anything else     -> forward
//   TargetServlet  -> /target  : shows how the request arrived
//
// Needs the Servlet API (javax.servlet, servlet-api.jar) and Apache Tomcat.
//   http://localhost:8080/<project>/initial                  (forwarded)
//   http://localhost:8080/<project>/initial?action=redirect  (redirected)
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/initial")
public class program16 extends HttpServlet {   // InitialServlet

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("redirect".equals(action)) {
            response.sendRedirect("target?action=redirected");
        } else {
            request.getRequestDispatcher("/target").forward(request, response);
        }
    }

    @WebServlet("/target")
    public static class TargetServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String action = request.getParameter("action");
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            if ("redirected".equals(action)) {
                response.getWriter().println("<h1>This request was redirected!</h1>");
            } else {
                response.getWriter().println("<h1>This request was forwarded!</h1>");
            }
            response.getWriter().println("</body></html>");
        }
    }
}
