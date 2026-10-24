package com.example;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/initial")
public class Program16Initial extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
String action = request.getParameter("action");
if ("redirect".equals(action)) {
response.sendRedirect("target?action=redirected");
} else {
request.getRequestDispatcher("target").forward(request, response);
}
}
}