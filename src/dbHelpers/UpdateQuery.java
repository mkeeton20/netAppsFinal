/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Product;

/**
 * @author Steed
 *
 */
public class UpdateQuery {
	
	private Connection connection;
	private String pName;
	
	public UpdateQuery(String dbName, String uname, String pwd , String pName){
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		this.pName= pName;
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
	
	public void doUpdate(Product product){
		String query = "update products set quant=? where name=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, product.getQuant());
			ps.setString(2,pName);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
