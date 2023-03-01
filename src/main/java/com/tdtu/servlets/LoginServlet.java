package com.tdtu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HashMap<String, String> users = new HashMap<String, String>();

    public LoginServlet() {
        super();
        users.put("admin", "admin");
        users.put("user", "user");
        users.put("guest", "guest");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        if (users.containsKey(username) && users.get(username).equals(password)) {
            out.println("<h3>Login successfully!</h3>");
        } else {
            out.println("<h3>Login failed!</h3>");
        }
    }

}
