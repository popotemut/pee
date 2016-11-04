/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int303.practice.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.StringTokenizer;
import sit.int303.practice.model.ConnectionBuilder;

/**
 *
 * @author Khaitong
 */
public class ImportPokemon {

    public static void main(String[] args) throws FileNotFoundException, SQLException {
        String sql = "insert into pokemon values(?, ?, ?, ?, ?, ?, ?, ?)"; //เพิ่ม
        File f = new File("pokemon.csv");
        Scanner sc = new Scanner(f);   //ไปอ่านจากFile
        Connection conn = ConnectionBuilder.getCon();
        PreparedStatement pstm = conn.prepareStatement(sql);
        while (sc.hasNextLine()) {//หาว่าทั้งบรรทัด
            String line = sc.nextLine();//อ่านทั้งบรรทัด
            StringTokenizer stk = new StringTokenizer(line, ","); //แยกคำด้วย ,
            int col = 1;
            while (stk.hasMoreElements()) {
                switch (col) {
                    case 2:
                        pstm.setString(col, stk.nextElement().toString()); //แปลงเป็นString
                        break;
                    default:
                        int value = Integer.parseInt(stk.nextElement().toString());
                        pstm.setInt(col, value);
                }
                col++;
                System.out.println();
            }
            pstm.addBatch();//เอาเข้าไว้ในBatch File
            System.out.println("----------------------------------------");
        }
        pstm.executeBatch();
        sc.close();

    }

}
