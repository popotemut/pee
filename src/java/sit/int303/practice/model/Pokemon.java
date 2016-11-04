/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int303.practice.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khaitong
 */
public class Pokemon {

    private final static String SQL_FIND_BY_ID = "select * from pokemon where id = ?";
    private final static String SQL_FIND_BY_NAME = "select * from pokemon where \"name\" like ?";
    private int id;
    private String name;
    private int height;
    private int weight;
    private int baseExperience;
    private int order;
    private boolean isDefault;

    public Pokemon(ResultSet rs) throws SQLException { 
        id = rs.getInt("id");
        name = rs.getString("name");
        height = rs.getInt("height");
        weight = rs.getInt("weight");
        baseExperience = rs.getInt("base_experience");
        order = rs.getInt("order");
        isDefault = rs.getInt("is_default") == 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public static Pokemon findById(int id) {
        Pokemon pm = null;
        Connection conn = ConnectionBuilder.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(SQL_FIND_BY_ID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                pm = new Pokemon(rs);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return pm;
    }

    public static List<Pokemon> findByName(String aName) {
        Pokemon pm = null;
        List<Pokemon> pms = null ;
        Connection conn = ConnectionBuilder.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(SQL_FIND_BY_NAME);
            pstm.setString(1, (aName+"%") );//เลือกทุกตัวที่ขึ้นต้นด้วย aName
            System.out.println(pstm);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                pm = new Pokemon(rs);
                if (pms == null) {
                    pms = new ArrayList(); //ถ้าหาไม่เจอก็จะnew ขึ้นมาใหม่ 
                }
                pms.add(pm);//แล้วเพิ่มลงไปให้
            }
            rs.close();
            pstm.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return pms;
    }

}
