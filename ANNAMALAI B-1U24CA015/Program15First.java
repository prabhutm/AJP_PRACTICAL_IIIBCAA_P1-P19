
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class Program15First extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
HttpSession session = request.getSession();
// Set an attribute in the session
session.setAttribute("user", "John Doe");
response.getWriter().println("<h1>Attribute set in session. Go to <a
href='SecondServlet'>Second Servlet</a></h1>");
}
}