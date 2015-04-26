package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;

public class UnameCheck {
	private Connection connection;
	private ResultSet results;
	private String uname;
	
	public UnameCheck(String dbName, String uname, String pwd, String username){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		this.uname = username;
		//set up the driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	public void doRead(){
		String query = "select * from users where uname =="+uname;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean check(){
		try {
			if(this.results.next()){
				return false;
			}
			else{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
		
	}
}