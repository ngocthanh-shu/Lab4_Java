package com.tdtu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlServlet extends HttpServlet {
    public ControlServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String action = request.getParameter("page");
        PrintWriter out = response.getWriter();
        if (action != null) {
            if (action.equals("about")) {
                request.getRequestDispatcher("about.jsp").forward(request, response);
            } else if (action.equals("contact")) {
                request.getRequestDispatcher("contact.jsp").forward(request, response);
            } else if (action.equals("help")) {
                request.getRequestDispatcher("help.jsp").forward(request, response);
            }
        } else {
            out.println("<h3>Page not found!</h3>");
        }
    }
}
