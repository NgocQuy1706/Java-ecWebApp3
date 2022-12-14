package com.ute.ecwebapp3.models;

import com.ute.ecwebapp3.beans.Category;
import com.ute.ecwebapp3.utils.DButils;
import org.sql2o.Connection;
import java.util.List;

public class CategoryModel {

    public static List<Category> findAll() {
            final String query = "select * from Categories";
            try (Connection con = DButils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Category.class);

        }
    }

    public static void add(Category c) {
        String insertSql = "insert into categories(CatName)  values (:CatName)";
        try (Connection con = DButils.getConnection()) {
            con.createQuery(insertSql)
                    .addParameter("CatName", c.getCatName())
                    .executeUpdate();
        }
    }

    public static void update(Category c) {
        String sql = "update  categories set CatName=:CatName where CatID = :CatID";
        try (Connection con = DButils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("CatID", c.getCatID())
                     .addParameter("CatName", c.getCatName())
                     .executeUpdate();
        }
    }

    public static void delete(int id) {
        String sql = "delete from categories where CatID = :CatID";
        try (Connection con = DButils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("CatID", id)
                    .executeUpdate();
        }
    }

    public static Category findByID(int id) {
        final String query = "select * from Categories where CatID= :CatID  ";
        try (Connection con = DButils.getConnection()) {
            List<Category> list =  con.createQuery(query)
                    .addParameter("CatID",id)
                    .executeAndFetch(Category.class);

            if (list.size() == 0) {
                return null;
            }
            return list.get(0);
        }
    }


}
