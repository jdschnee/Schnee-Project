package com.schnee.dao;
import java.sql.*;
public class ResetDAO {
	String update = "update login set pw=? where un=?";
	String url = "jdbc:mysql://ec2-18-189-178-60.us-east-2.compute.amazonaws.com:3306/myDBSchnee";
	String uName = "jdschnee";
	String pWord = "#FordFusion2013";
	
	public boolean changeCredentials(String un, String pw) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uName,pWord);
			PreparedStatement ps = con.prepareStatement(update);
			ps.setString(1, pw);
			ps.setString(2, un);
			int count = ps.executeUpdate();
			if(count==1) {
				ps.close();
				con.close();
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
