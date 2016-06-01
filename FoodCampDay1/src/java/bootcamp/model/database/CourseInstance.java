/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.model.database;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oFNo's PC
 */
public class CourseInstance {
    
    private static final String TABLE_NAME = "course_instances";
    
    private Long courseId;
    private String courseCode;
    private String courseName;
    private Date year;
    private Integer semester;
    private String courseInstanceName;

    public static List<CourseInstance> getCourseInstanceBySemester(Integer semester, String year, Connection con){
        List<CourseInstance> courseInstances = new ArrayList<CourseInstance>();
        try{
        PreparedStatement ps = con.prepareStatement("SELECT * FROM "+TABLE_NAME+" WHERE academic_year = ? and semester = ?");
        ps.setString(1, year);
        ps.setInt(2, semester);
        ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CourseInstance tem = new CourseInstance();
                ORM(rs, tem);
                courseInstances.add(tem);
                System.out.println(tem);
            }
        }catch(Exception e){
            System.out.println("Hello");
        }
        //Hint : This method call another method in this class.
        
        
        return courseInstances;
    }

    @Override
    public String toString() {
        return "CourseInstance{" + "courseId=" + courseId + ", courseCode=" + courseCode + ", courseName=" + courseName + ", year=" + year + ", semester=" + semester + ", courseInstanceName=" + courseInstanceName + '}';
    }
    
//    public static List<CourseInstance> getCourseInstanceBySemester(String year, String semester, Connection con){
//        List<CourseInstance> courseInstances = new ArrayList<CourseInstance>();
//        //Hint : This method connect with database.
//        
//        return courseInstances;
//    }
    
    public static CourseInstance getCourseInstance(Long courseId, Connection connection){
        CourseInstance courseInstance = null;
        try{
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM "+TABLE_NAME+" WHERE crsinstance_id = ?");
        ps.setLong(1, courseId);
        ResultSet rs = ps.executeQuery();
            while(rs.next()){
                courseInstance = new CourseInstance();
                ORM(rs, courseInstance);
                System.out.println("CCC +"+ courseInstance);
            }
        }catch(SQLException e){
            System.out.println("Error 2");
        }
        return courseInstance;
        
    }
    
    public static void ORM(ResultSet rs, CourseInstance courseInstance){
        try{
         if(courseInstance == null){
            courseInstance = new CourseInstance();
        }
         
        courseInstance.setCourseId(rs.getLong("crsinstance_id"));
        courseInstance.setCourseCode(rs.getString("course_code"));
        courseInstance.setCourseName(rs.getString("course_name"));
        courseInstance.setYear(rs.getDate("academic_year"));
        courseInstance.setSemester(rs.getString("semester"));
        courseInstance.setCourseInstanceName("crsinstance_name");
        }catch (SQLException e){
        
            System.out.println("Error 3");
        }
    }
    
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }
    
    public void setSemester(String semester){
        setSemester(ApplicationData.getSemesterNumber(semester));
    }

    public String getCourseInstanceName() {
        return courseInstanceName;
    }

    public void setCourseInstanceName(String courseInstanceName) {
        this.courseInstanceName = courseInstanceName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final CourseInstance other = (CourseInstance) obj;
        if (this.courseId != other.courseId) {
            return false;
        }
        return true;
    }
    
    
}
