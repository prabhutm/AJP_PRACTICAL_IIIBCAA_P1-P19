import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/SecondServlet")
public class Program15Second extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
HttpSession session = request.getSession();
// Retrieve the attribute from session
String user = (String) session.getAttribute("user");
if (user != null) {
response.getWriter().println("<h1>Welcome " + user + "</h1>");
}
else {
response.getWriter().println("<h1>No user found in session.</h1>");
}
}
}