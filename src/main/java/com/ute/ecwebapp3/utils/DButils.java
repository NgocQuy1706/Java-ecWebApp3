package com.ute.ecwebapp3.utils;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DButils {
    static Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/qlbh", "root", null);
    public static Connection getConnection() {
        return sql2o.open();
    }

    public static void redirect(String url, HttpServletRequest request, HttpServletResponse response) throws  SecurityException, IOException {
        response.sendRedirect(request.getContextPath() + url);

    }
}
