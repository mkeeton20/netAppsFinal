package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;

public class ReadCart {
	private Connection connection;
	private ResultSet results;
	private String pName;
	
	public ReadCart(String dbName, String uname, String pwd, String pName){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		this.pName = pName;
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
		String query = "select * from products where name='{pName}'";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Product getProduct(){
		Product product = new Product();
		try {
			this.results.next();
				
				product.setName(this.results.getString("name"));
				product.setId(this.results.getInt("idproducts"));
				product.setDescription(this.results.getString("Description"));
				product.setPrice(this.results.getDouble("Price"));
				product.setQuant(this.results.getInt("Quant"));
				product.setImg(this.results.getString("img"));
				
			}
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
		
	}
}
