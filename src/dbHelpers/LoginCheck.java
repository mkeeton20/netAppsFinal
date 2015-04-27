package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCheck {
	private Connection connection;
	private ResultSet results;
	private String uname;
	private String password;
	
	public LoginCheck(String dbName, String uname, String pwd, String username, String Password){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		this.uname = username;
		this.password = Password;
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
		String query = "select * from users where userName ="+"'"+uname+"'"+" and pwd="+"'"+password+"'";
		
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
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
		
	}
}
