/**
 * 
 */
package dbHelpers;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import model.Product;

/**
 * @author Steed
 *
 */
public class ReadQuery {
	
	private Connection connection;
	private ResultSet results;
	
	public ReadQuery(String dbName, String uname, String pwd){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
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
		String query = "select * from products";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getHTMLTable(){
		String table = "";
		table += "<table border=1>";
		table += "<tr><td>SKU</td><td>Product Type</td><td>Flavor</td><td>Cost</td><td>Price</td><td>Quantity</td><td>Action</td></tr>";
		
		try {
			while(this.results.next()){
	/*			Product product = new Product();
				product.setSKU(this.results.getString("SKU"));
				product.setType(this.results.getString("ProductType"));
				product.setFlavor(this.results.getString("Flavor"));
				product.setCost(this.results.getDouble("Cost"));
				product.setPrice(this.results.getDouble("Price"));
				product.setQuantity(this.results.getInt("Quantity"));
				
				table +="<tr>";
				table +="<td>";
				table +=	product.getSKU();
				table +="</td>";
				table +="<td>";
				table +=	product.getType();
				table +="</td>";
				table +="<td>";
				table +=	product.getFlavor();
				table +="</td>";
				table +="<td>";
				table +=	product.getCost();
				table +="</td>";
				table +="<td>";
				table +=	product.getPrice();
				table +="</td>";
				table +="<td>";
				table +=	product.getQuantity();
				table +="</td>";
				table +="<td>";
				table += "<a href=update?SKU=" + product.getSKU() + ">update</a> <a href=delete?SKU=" + product.getSKU() +">delete</a>";
				table +="</td>";
				table +="</tr>"; */
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table += "</table>";
		return table;
	}

}
