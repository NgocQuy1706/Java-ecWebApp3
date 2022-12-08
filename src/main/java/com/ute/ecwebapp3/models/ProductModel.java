package com.ute.ecwebapp3.models;


import com.ute.ecwebapp3.beans.Product;
import com.ute.ecwebapp3.utils.DButils;
import org.sql2o.Connection;
import java.util.List;

public class ProductModel {

    public static List<Product> findAll() {
            final String query = "select * from products";
            try (Connection con = DButils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Product.class);

        }
    }

    public static Product findByID(int id) {
        final String query = "select * from products where ProID= :ProID  ";
        try (Connection con = DButils.getConnection()) {
            List<Product> list =  con.createQuery(query)
                    .addParameter("ProID",id)
                    .executeAndFetch(Product.class);

            if (list.size() == 0) {
                return null;
            }
            return list.get(0);
        }
    }

    public static void add(Product p) {
        String insertSql = "INSERT INTO products (ProID, ProName, TinyDes, FullDes, Price, CatID, Quantity) VALUES (:proid,:proname,:tinydes,:fulldes,:price,:catid,:quantity)\n";
        try (Connection con = DButils.getConnection()) {
            con.createQuery(insertSql)
                    .addParameter("proid", p.getProID())
                    .addParameter("proname", p.getProName())
                    .addParameter("tinydes", p.getTinyDes())
                    .addParameter("fulldes", p.getFullDes())
                    .addParameter("price", p.getPrice())
                    .addParameter("quantity", p.getQuantity())
                    .executeUpdate();
        }
    }

    public static void update(Product p) {
        String sql = "UPDATE products SET  ProName = :proname, TinyDes = :tinydes, FullDes = :fulldes, Price = :price, CatID = :catid, Quantity = :quantity WHERE ProID = :proid";
        try (Connection con = DButils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("proid", p.getProID())
                    .addParameter("proname", p.getProName())
                    .addParameter("tinydes", p.getTinyDes())
                    .addParameter("fulldes", p.getFullDes())
                    .addParameter("price", p.getPrice())
                    .addParameter("quantity", p.getQuantity())
                     .executeUpdate();
        }
    }

    public static void delete(int id) {
        String sql = "delete from products where ProID = :ProID";
        try (Connection con = DButils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("ProID", id)
                    .executeUpdate();
        }
    }



}
