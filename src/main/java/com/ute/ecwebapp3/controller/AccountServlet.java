package com.ute.ecwebapp3.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.ute.ecwebapp3.beans.User;
import com.ute.ecwebapp3.models.UserModel;
import com.ute.ecwebapp3.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "AccountServlet", value = "/Account/*")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String path = request.getPathInfo();
            switch (path) {
                case "/Register":
                    ServletUtils.forward("/views/vwAccount/Register.jsp", request,response);
                    break;

                case "/Login":
                    ServletUtils.forward("/views/vwAccount/Login.jsp", request,response);
                    break;

                case "/Profile":
                    ServletUtils.forward("/views/vwAccount/Profile.jsp", request,response);
                    break;

                case "/IsAvailable":
                    String username = request.getParameter("user");
                    User user = UserModel.findByUsername(username);
                    boolean isAvailable = (user == null);

                    PrintWriter out = response.getWriter();
                    response.setContentType("application/json");
                    response.setCharacterEncoding("utf-8");

                    out.print(isAvailable);
                    out.flush();
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
            case "/Register":
                registerUser(request, response);
                break;

            case "/Login":
                login(request, response);
                break;

            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }
    private static void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawpwd = request.getParameter("rawpwd");
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, rawpwd.toCharArray());

        String strDob = request.getParameter("dob") + " 00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dob = LocalDateTime.parse(strDob, df);

        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int permission = 0;

        User c = new User(0, username, bcryptHashString, name, email, dob, permission);
        UserModel.add(c);
        ServletUtils.forward("/views/vwAccount/Register.jsp", request, response);
    }

    private static void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("CatName");
//        Category c= new Category(name);
//        CategoryModel.add(c);
//        ServletUtils.forward("/views/vwCategory/Add.jsp", request, response);
    }
}