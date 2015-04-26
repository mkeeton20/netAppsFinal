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
		String table = "<div class='container'>";
		try {
			while(this.results.next()){
				Product product = new Product();
				product.setName(this.results.getString("name"));
				product.setId(this.results.getInt("idproducts"));
				product.setDescription(this.results.getString("Description"));
				product.setPrice(this.results.getDouble("Price"));
				product.setQuant(this.results.getInt("Quant"));
				product.setImg(this.results.getString("img"));
				table += String.format("<div class='row'> <div class='col-sm-3'> <br> <img class='img-responsive' src='%s' data-alt='' data-title=''> <br> </div> <div class='col-sm-9'> <h2>%s</h2> <ul class='list-group ticketView'> <li class='list-group-item ticketView'> <span class='label label-default'>Price</span> <label>%d</label> </li> <li class='list-group-item ticketView'> <span class='label label-default'>Description</span> <label>%s</label> </li> <li class='list-group-item ticketView'> <span class='label label-default'>In Stock</span> <label>%d</label> </li> <li class='list-group-item ticketView'> <span class='label label-default'>Quantity:</span> <br> <br> <form> <input type = 'text' size='2' maxlength='2'> <input type='submit' value='add to cart'> </form> </li> </ul> </div><!--/col--> </div><!--/row--> </div>",product.getImg(),product.getName(),product.getPrice(),product.getDescription(),product.getQuant());
				
			}
			table+="</div>";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table += "</table>";
		return table;
	}

}
