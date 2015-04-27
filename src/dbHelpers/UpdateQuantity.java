package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Product;

public class UpdateQuantity {
	
	private Connection connection;
	
	public UpdateQuantity(String dbName, String uname, String pwd){
		
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
	
	public void doQuantUpdate(Product product){
		
		String query = "update products set quant=? where idproducts = ?";
		
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				
				ps.setInt(1, product.getQuant());
				
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
