package myCrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.connectionPool.connectionpool;

import models.Courses;

public class CourseCRUD {

	public void insertCourse(Courses c) {

	    String sql = "INSERT INTO courses(name, credits) VALUES (?, ?)";

	    try (Connection con = connectionpool.fetchConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, c.getName());
	        ps.setInt(2, c.getCredits());

	        ps.executeUpdate();
	        System.out.println("Course inserted successfully!");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void updateCourse(Courses c) {

	    String sql = "UPDATE courses SET name=?, credits=? WHERE cid=?";

	    try (Connection con = connectionpool.fetchConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, c.getName());
	        ps.setInt(2, c.getCredits());
	        ps.setInt(3, c.getCid());

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Course updated successfully!");
	        } else {
	            System.out.println("Course not found!");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void deleteCourse(int cid) {

	    String sql = "DELETE FROM courses WHERE cid=?";

	    try (Connection con = connectionpool.fetchConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, cid);

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Course deleted successfully!");
	        } else {
	            System.out.println("Course not found!");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void getAllCourses() {

	    String sql = "SELECT * FROM courses";

	    try (Connection con = connectionpool.fetchConnection();
	         Statement st = con.createStatement();
	         ResultSet rs = st.executeQuery(sql)) {

	        while (rs.next()) {

	            System.out.println(
	                rs.getInt("cid") + " | " +
	                rs.getString("name") + " | " +
	                rs.getInt("credits")
	            );
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}


