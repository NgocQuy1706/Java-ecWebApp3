package com.ute.ecwebapp3.controller;


import com.ute.ecwebapp3.beans.Product;
import com.ute.ecwebapp3.models.ProductModel;
import com.ute.ecwebapp3.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCProductServlet", value = "/Admin/Product/*")
public class AdminProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String path = request.getPathInfo();
            if (path == null || path.equals("/")){
                path = "/Index";
            }
            switch (path) {
                case "/Index":
                    List<Product>  list = ProductModel.findAll();
                    request.setAttribute("products",list);
                    ServletUtils.forward("/views/vwProduct/Index.jsp", request,response);
                    break;

                case "/Add":
                    ServletUtils.forward("/views/vwProduct/Add.jsp", request,response);
                    break;

                case "/Edit":
                    int id = 0;
                    try {
                             id = Integer.parseInt(request.getParameter("id"));
                    } catch (NumberFormatException e) {

                    }
                    Product c = ProductModel.findByID(id);

                    if (c != null) {
                        request.setAttribute("Product",c);
                        ServletUtils.forward("/views/vwProduct/Edit.jsp",request,response);
                    }
                    else {
                        ServletUtils.redirect("/Admin/Product",request,response);
//                        ServletUtils.forward("/views/204.jsp",request,response);

                    }
                    ServletUtils.forward("/views/vwProduct/Edit.jsp", request,response);
                    break;


                default:
                    ServletUtils.forward("/views/404.jsp", request,response);
                    break;
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/Add":
                addProduct(request, response);
                break;

            case "/Delete":
                deleteProduct(request,response);
                break;

            case "/Update":
                updateProduct(request,response);
                break;

            default:
                ServletUtils.forward("/views/404.jsp", request,response);
                break;
        }
    }

    private static void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("ProName");
        Product c= new Product(name);
        ProductModel.add(c);
        ServletUtils.forward("/views/vwProduct/Add.jsp", request, response);
    }

    private static void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("ProID"));
        String name = request.getParameter("ProName");
        Product c= new Product(id,name);
        ProductModel.update(c);
        ServletUtils.redirect("/Admin/Product",request,response);
    }

    private static void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("ProID"));
        ProductModel.delete(id);
        ServletUtils.redirect("/Admin/Product",request,response);
    }
}

