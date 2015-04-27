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

import dbHelpers.LoginCheck;
import model.Cart;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
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
		session.setAttribute("cart",cart);
		session.setAttribute("totalCost", 0);
		String url = "/index.jsp";
		String user = request.getParameter("userLogin");
		String password = request.getParameter("userPassword");
		LoginCheck lc = new LoginCheck("shopping","root","",user,password);
		lc.doRead();
		
		if (user == null && user.length() == 0 && password == null && password.length() == 0) {
            url = "/index.jsp";
            request.setAttribute("error", "Username & Password must not be empty.");
        }else{
         if(lc.check()){
        	 url = "/getProducts";
         }
         else{
        	 url = "/index.jsp";
             request.setAttribute("error", "Username or Password are incorrect");
         }
        }
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
