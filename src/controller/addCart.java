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
		
		int quantity = (Integer)(request.getAttribute("quantSelect"));
		
		
		String pName = request.getParameter("name");
		ReadCart rc = new ReadCart("shopping","root","",pName);
		rc.doRead();
		Product product = rc.getProduct();
		ArrayList cart = (ArrayList) session.getAttribute("cart");
		cart.add(product);
		UpdateQuantity uc = new UpdateQuantity("products","root","",pName,quantity);
		uc.doQuantUpdate(product, quantity);
		
		session.setAttribute("cart", cart);
		
		String url = "getCart";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
