package myCrud;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.connectionPool.connectionpool;

import models.Enrollments;

public class EnrollmentCRUD {

	public int insertEnrollment(Enrollments e) {

        String sql = "INSERT INTO enrollments(student_id, course_id, grade) VALUES (?, ?, ?)";

        try (Connection con = connectionpool.fetchConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, e.getstudent_id());
            ps.setInt(2, e.getCourseid());
            ps.setString(3, e.getGrade());

            return ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

   
//    public int updateGrade(int eid, String grade) {
//
//        String sql = "UPDATE enrollments SET grade=? WHERE eid=?";
//
//        try (Connection con = ConnectionPool.fetchConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setString(1, grade);
//            ps.setInt(2, eid);
//
//            return ps.executeUpdate();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return 0;
//        }
//    }

   
    public int deleteEnrollment(int eid) {

        String sql = "DELETE FROM enrollments WHERE eid=?";

        try (Connection con = connectionpool.fetchConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, eid);

            return ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

 
    public void getAllEnrollments() {

        String sql = "SELECT * FROM enrollments";

        try (Connection con = connectionpool.fetchConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                System.out.println(
                        rs.getInt("eid") + " | " +
                        rs.getInt("student_id") + " | " +
                        rs.getInt("course_id") + " | " +
                        rs.getString("grade")
                );
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void getEnrollmentDetails() {

        String sql = "SELECT s.name, c.name, e.grade " +
                     "FROM enrollments e " +
                     "JOIN students s ON e.student_id = student_.id " +
                     "JOIN courses c ON e.course_id = c.cid";

        try (Connection con = connectionpool.fetchConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                System.out.println(
                    rs.getString("name") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("grade")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getStudentEnrollments(int student_id) {

        String sql = "SELECT c.name " +
                     "FROM enrollments e " +
                     "JOIN courses c ON e.course_id = c.cid " +
                     "WHERE e.student_id = ?";

        try (Connection con = connectionpool.fetchConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student_id);   // sid comes from method parameter
            ResultSet rs = ps.executeQuery();

            System.out.println("Enrolled Courses:");

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateGrade(int student_id,int course_id,String grade) {
    	Connection connection=null;
    	try{connection=connectionpool.fetchConnection();
    	String sql="call updategrade(?,?,?)";
    			CallableStatement cs=connection.prepareCall(sql);
    			cs.setString(3, grade);
    			cs.setInt(1, student_id);
    			cs.setInt(2, course_id);
    			cs.executeUpdate();	
    			System.out.println("Grade updated Successfully");
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	finally {
    		connectionpool.receiveConnection(connection);
    	}
    }

    public void viewGrade(int student_id) {
    	String sql="SELECT student_id, grade FROM enrollments WHERE student_id=?";
    	Connection connection=null;
    	try{connection=connectionpool.fetchConnection();
    			PreparedStatement preparedstatement=connection.prepareStatement(sql);
    			preparedstatement.setInt(1, student_id);
    			ResultSet resultset=preparedstatement.executeQuery();
    			while(resultset.next()) {
    				System.out.println("student_id=>"+resultset.getInt("student_id")+
    						" | student grade=>"+resultset.getString("grade")+ " | ");
    			}
    					
    		} catch (SQLException  e) {
    			  
    			e.printStackTrace();
    		}
    	finally {
    		connectionpool.receiveConnection(connection);
    	}
    }

    public void avggpa(int student_id) {
    	Connection connection=null;
    	try{connection=connectionpool.fetchConnection();
    	String sql="select avggpa(?)";
    			CallableStatement cs=connection.prepareCall(sql);
    			cs.setInt(1, student_id);
    			ResultSet rs=cs.executeQuery();	
    			rs.next();
    			System.out.println("Student GPA: "+rs.getInt(1));
    			
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	finally {
    		connectionpool.receiveConnection(connection);
    	}
    }

}
