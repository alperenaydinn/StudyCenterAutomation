package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student extends User{
	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	public Student(int user_id, String name, String tc_no, String password, String type) {
		super(user_id, name, tc_no, password, type);
	}
	
	public Student() {}

	
	
	public boolean addAppointment(int teacher_id,int student_id,String teacher_name,String student_name,String appDate) throws SQLException{
		int key = 0;
		String query = "INSERT INTO appointment" + "(teacher_id,teacher_name,student_id,student_name,app_date) VALUES" + "(?,?,?,?,?)" ;
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, teacher_id);
			preparedStatement.setString(2, teacher_name);
			preparedStatement.setInt(3, student_id);
			preparedStatement.setString(4, student_name);
			preparedStatement.setString(5, appDate);
			preparedStatement.executeUpdate();
			key = 1;
						
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(key==1)
			return true;
		else
			return false;
		
	}
	public boolean updateWhourStatus(int teacher_id,String wdate) throws SQLException{
		int key = 0;
		String query = "UPDATE workhour SET status = ? WHERE teacher_id = ? AND wdate = ?" ;
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, "p");
			preparedStatement.setInt(2, teacher_id);
			preparedStatement.setString(3, wdate);
			
			
			key = 1;
						
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(key==1)
			return true;
		else
			return false;
		
	}
	
	
	
	
}
