package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dbHelpers.ReadQuery;

import dbHelpers.UpdateQuery;
/**
 * Servlet implementation class getProducts
 */
@WebServlet("/getProducts")
public class getProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getProducts() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String SKU = request.getParameter("SKU");
		String type = request.getParameter("type");
		String flavor = request.getParameter("flavor");
		String cost = request.getParameter("cost");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
				
		UpdateQuery.doUpdate();
		
		String url = "/getShoppingCart";

	
		ReadQuery rq = new ReadQuery("shopping","root","");
		
		rq.doRead();
		
		String view = rq.getHTMLTable();
		request.setAttribute(view, "view");
			
		String url = "products.jsp";

		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
