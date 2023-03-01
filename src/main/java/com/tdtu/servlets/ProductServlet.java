package com.tdtu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
// import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tdtu.model.Product;

public class ProductServlet extends HttpServlet {
    List<Product> list;

    public ProductServlet() {
        super();
        list = new ArrayList<Product>();
    }

    // return file json
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        // get all product
        if (request.getParameter("id") == null) {
            out.println("[");
            for (int i = 0; i < list.size(); i++) {
                out.println(list.get(i).toString());
                if (i < list.size() - 1) {
                    out.println(",");
                }
            }
            out.println("]");
        } else {
            // get product by id
            String idString = request.getParameter("id");
            int id = Integer.parseInt(idString);
            out.println("[");
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == id) {
                    out.println(list.get(i).toString());
                    break;
                }
            }
            out.println("]");
        }
    }

    // add product with id auto increment
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int id = list.size() + 1;
        Product product = new Product(id, name, price);
        list.add(product);
    }

    // update product
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        Product product = new Product(id, name, price);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.set(i, product);
                break;
            }
        }
    }

    // delete product
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                break;
            }
        }
    }
}
