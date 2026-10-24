package com.example;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/target")
public class Program16Target extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
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