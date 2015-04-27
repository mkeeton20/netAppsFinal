package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Product;

public class UpdateQuantity {
	
	private Connection connection;
	private int id;
	private int qty;
	
	public UpdateQuantity(String dbName, String uname, String pwd, int id, int qty){
		this.id = id;
		this.qty=qty;
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doQuantUpdate(){
		
		
		
		String query = "update products set quant=? where idproducts = ?";
		
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				
				ps.setInt(1,qty);
				ps.setInt(2, id);
				
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
