/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.model.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oFNo's PC
 */
public class Student implements Serializable{

    Long studentId;
    String name;
    String tel;
    String email;
    private static final String TABLE_NAME = "students";

    public Student() {
    }

    public Student(Long studentId, String name) {
        this(studentId, name, null, null);
    }

    public Student(Long studentId, String name, String tel, String email) {
        this.studentId = studentId;
        this.name = name;
        this.tel = tel;
        this.email = email;
    }
    
    public static Student getStudent(Long studentId, Connection connection) throws SQLException {
        Student std = null;        
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM "+TABLE_NAME+" WHERE student_id = ?");
        ps.setLong(1, studentId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                std = new Student();
                ORM(rs,std);
            }
        return std;

    }

    private static void ORM(ResultSet rs, Student student) throws SQLException {
        if(student == null){
            student = new Student();
        }
        student.setStudentId(rs.getLong("student_id"));
        student.setName(rs.getString("name"));
        student.setTel(rs.getString("tel"));
        student.setEmail(rs.getString("email"));
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.studentId != other.studentId) {
            return false;
        }
        return true;
    }
}
