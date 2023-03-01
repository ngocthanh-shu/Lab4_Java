package com.tdtu.servlets;

// import java.io.BufferedInputStream;
// import java.io.BufferedOutputStream;
// import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
// import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
// import java.io.PrintWriter;
import java.net.URL;
// import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
// import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Image1Servlet extends HttpServlet {

    public Image1Servlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpeg");
        String url = "https://www.humanesociety.org/sites/default/files/2020-07/kitten-510651.jpg";
        URL urlConn = new URL(url);
        InputStream in = urlConn.openStream();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1 != (n = in.read(buf))) {
            output.write(buf, 0, n);
        }
        in.close();
        byte[] data = output.toByteArray();
        response.setContentLength(data.length);
        ServletOutputStream out = response.getOutputStream();
        out.write(data);
        out.flush();
        out.close();
    }
}
