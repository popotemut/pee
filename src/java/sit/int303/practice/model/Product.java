/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int303.practice.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INT303
 */
public class Product implements Serializable {

    private int productId;
    private String productType;
    private double price;
    private int quantityOnHand;
    private boolean available;
    private String description;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Product findById(int id) {
        Product p = null;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sqlCmd = "select  p.product_id, p.purchase_cost + p.markup as price, p.available, "
                    + " p.quantity_on_hand, p.description, pc.description as product_type "
                    + " from product p, product_code pc "
                    + " where p.product_code = pc.prod_code and product_id = ?";
            PreparedStatement stm = con.prepareStatement(sqlCmd);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                p = new Product();
                getProduct(rs, p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }

    private static void getProduct(ResultSet rs, Product p) throws SQLException {
        p.setProductId(rs.getInt("product_id"));
        p.setAvailable(rs.getString("available").equalsIgnoreCase("true"));
        p.setPrice(rs.getDouble("price"));
        p.setDescription(rs.getString("description"));
        p.setQuantityOnHand(rs.getInt("quantity_on_hand"));
        p.setProductType(rs.getString("product_type"));
    }

    public static List<Product> findByName(String str) {
        List<Product> products = null;
        Product p = null ;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sqlCmd = "select  p.product_id, p.purchase_cost + p.markup as price, p.available, "
                    + " p.quantity_on_hand, p.description, pc.description as product_type "
                    + " from product p, product_code pc "
                    + " where p.product_code = pc.prod_code AND lower(p.description) like ? OR lower(pc.description) like ?";
            PreparedStatement stm = con.prepareStatement(sqlCmd);
            stm.setString(1, "%"+ str.toLowerCase() + "%");
            stm.setString(2, "%"+ str.toLowerCase() + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                if (products == null) {
                    products = new ArrayList<>();
                }
                p = new Product();
                getProduct(rs, p);
                products.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return products ;
    }

    public static List<Product> findByPrice(double lb,  double ub ) {
        if (lb>ub) {
            double tmp = lb ;
            ub = lb ;
            lb = tmp ;
        }
        List<Product> products = null;
        Product p = null ;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sqlCmd = "select  p.product_id, p.purchase_cost + p.markup as price, p.available, "
                    + " p.quantity_on_hand, p.description, pc.description as product_type "
                    + " from product p, product_code pc "
                    + " where p.product_code = pc.prod_code AND "
                    +" p.purchase_cost + p.markup>= ? AND p.purchase_cost + p.markup <= ? ";
            PreparedStatement stm = con.prepareStatement(sqlCmd);
            stm.setDouble(1, lb);
            stm.setDouble(2, ub);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                if (products == null) {
                    products = new ArrayList<>();
                }
                p = new Product();
                getProduct(rs, p);
                products.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return products ;
    }

}

