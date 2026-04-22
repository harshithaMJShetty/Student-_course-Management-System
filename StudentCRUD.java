package myCrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.util.Scanner;

import com.connectionPool.connectionpool;

import models.Students;

public class StudentCRUD {

	public void single_insertStudents(Students s) {
		String sql = "INSERT INTO students(name, email, dob) VALUES (?, ?, ?)";

        try (Connection con = connectionpool.fetchConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setDate(3, s.getDob());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student inserted successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public int[] multiple_insertStudents(int n) {

	    String sql = "INSERT INTO students(name, email, dob) VALUES (?, ?, ?)";

	    try (Connection con = connectionpool.fetchConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         Scanner sc = new Scanner(System.in)) {

	        for (int i = 1; i <= n; i++) {

	            System.out.println("Enter name:");
	            String name = sc.nextLine();

	            System.out.println("Enter email:");
	            String email = sc.nextLine();

	            System.out.println("Enter dob (yyyy-mm-dd):");
	            Date dob = Date.valueOf(sc.nextLine());

	            ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setDate(3, dob);

	            ps.addBatch();
	        }

	        return ps.executeBatch();

	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	
	public void updateStudent(Students s) {

	    String sql = "UPDATE students SET name=?, email=?, dob=? WHERE id=?";

	    try (Connection con = connectionpool.fetchConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, s.getName());
	        ps.setString(2, s.getEmail());
	        ps.setDate(3, s.getDob());
	        ps.setInt(4, s.getId());   

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Student updated successfully!");
	        } else {
	            System.out.println("Student not found!");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void deleteStudent(int id) {

	    String sql = "DELETE FROM students WHERE id=?";

	    try (Connection con = connectionpool.fetchConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, id);

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Student deleted successfully!");
	        } else {
	            System.out.println("Student not found!");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void getAllStudents() {

	    String sql = "SELECT * FROM students";

	    try (Connection con = connectionpool.fetchConnection();
	         Statement st = con.createStatement();
	         ResultSet rs = st.executeQuery(sql)) {

	        while (rs.next()) {

	            System.out.println(
	                rs.getInt("id") + " | " +
	                rs.getString("name") + " | " +
	                rs.getString("email") + " | " +
	                rs.getDate("dob")
	            );
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
