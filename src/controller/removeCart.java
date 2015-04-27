package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.ReadCart;
import dbHelpers.UpdateQuantity;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class removeCart
 */
@WebServlet("/removeCart")
public class removeCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int id =Integer.parseInt(request.getParameter("id"));
		Cart cart = (Cart) session.getAttribute("cart");
	    Product product = cart.getId(id);
		cart.remove(id);
		int quant = (Integer) session.getAttribute(request.getParameter("id"));
		int newQuant = product.getQuant()+quant;
		UpdateQuantity uc = new UpdateQuantity("shopping","root","",id,newQuant);
		uc.doQuantUpdate();
	
	String url = "/getCart";
	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	dispatcher.forward(request, response);
	}

}
