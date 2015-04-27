package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Product;

/**
 * Servlet implementation class getCart
 */
@WebServlet("/getCart")
public class getCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Cart cart = new Cart();
		int cost =  (Integer) request.getAttribute("cost");
		int totalCost = (Integer) session.getAttribute("totalCost")+cost;
		cart = (Cart) session.getAttribute("cart");
		ArrayList<Product> i = cart.getCart();
		String view ="<div class='container'>";
		for (Product product : i){
		view +=	"<div class='row'>";
        view +="<div class='col-sm-3'><br>";
        view += "<img class='img-responsive' src='"+ product.getImg()+"' data-alt='' data-title=''>";
        view +="<br>";              
        view +="</div>";
        view +="<div class='col-sm-9'>";
        view +="<h2>"+ product.getName()+"</h2>";
        view +="<ul class='list-group ticketView'>";
        view +="<li class='list-group-item ticketView'>";
        view +="<span class='label label-default'>Price</span>";
        view +="<label>"+ product.getPrice()+"</label>";
        view +="</li>";
        view +="<li class='list-group-item ticketView'>";
        view +="<span class='label label-default'>Description</span>";
        view +="<label>"+ product.getDescription()+"</label>";
        view +="</li>";
        view +="<li class='list-group-item ticketView'>";
        view +="<span class='label label-default'>Cost</span>";
        view +="<label>"+ cost+"</label>";
        view +="</li>";
        view +="<li class='list-group-item ticketView'>";
        view +="<span class='label label-default'><a href=removeCart?id="+ product.getId() +"> delete</a></span>";
        view +="<br> </li> </ul> </div><!--/col--> </div><!--/row-->";
		}
		view+="</div>";
		request.setAttribute("view", view);
		session.setAttribute("totalCost", totalCost);
		String url = "/cart.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	

}
