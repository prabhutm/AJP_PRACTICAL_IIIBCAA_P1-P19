package com.example;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/lifecycle")
public class Program14 extends HttpServlet {
@Override
public void init() throws ServletException {
System.out.println("Servlet is being initialized.");
}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
System.out.println("Handling GET request.");
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<html><body>");
out.println("<h1>Hello, this is the Lifecycle Servlet!</h1>");
out.println("</body></html>");
}
@Override
public void destroy() {
System.out.println("Servlet is being destroyed.");
}
}