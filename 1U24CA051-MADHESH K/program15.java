// Practical 15: Servlets sharing data through HttpSession
//   FirstServlet  -> /FirstServlet  : session.setAttribute("user", ...)
//   SecondServlet -> /SecondServlet : session.getAttribute("user")
//
// Needs the Servlet API (javax.servlet, servlet-api.jar) and Apache Tomcat.
// Open first:  http://localhost:8080/<project>/FirstServlet   then click the link.
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class program15 extends HttpServlet {   // FirstServlet

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        // Set an attribute in the session
        session.setAttribute("user", "John Doe");

        response.getWriter().println(
            "<h1>Attribute set in session. Go to <a href='SecondServlet'>Second Servlet</a></h1>");
    }

    @WebServlet("/SecondServlet")
    public static class SecondServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            response.setContentType("text/html");
            HttpSession session = request.getSession();

            // Retrieve the attribute from the session
            String user = (String) session.getAttribute("user");

            if (user != null) {
                response.getWriter().println("<h1>Welcome " + user + "</h1>");
            } else {
                response.getWriter().println("<h1>No user found in session.</h1>");
            }
        }
    }
}
