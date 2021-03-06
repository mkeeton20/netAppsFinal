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
import dbHelpers.ReadCart;
import dbHelpers.UpdateQuantity;
import dbHelpers.UpdateQuery;

/**
 * Servlet implementation class addCart
 */
@WebServlet("/addCart")
public class addCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCart() {
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
		
		int quantity =Integer.parseInt(request.getParameter("quantSelect")) ;
		
		
		String pName = request.getParameter("name");
		ReadCart rc = new ReadCart("shopping","root","",pName);
		rc.doRead();
		Product product = rc.getProduct();
		Cart cart = (Cart) session.getAttribute("cart");
		cart.add(product);
		String prodId = ""+product.getId();
		int cost = (int) (product.getPrice()*quantity);
		session.setAttribute("cart", cart);
		session.setAttribute(prodId,quantity);
		request.setAttribute("cost", cost);
		String url = "/getCart";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
