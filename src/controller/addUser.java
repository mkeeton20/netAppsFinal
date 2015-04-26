package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddQuery;
import dbHelpers.UnameCheck;

/**
 * Servlet implementation class addUser
 */
@WebServlet("/addUser")
public class addUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fName = request.getParameter("fnameA");
		String lName = request.getParameter("lnameA");
		String uName = request.getParameter("unameA");
		String email = request.getParameter("emailA");
		String password = request.getParameter("pwdA"); 
		UnameCheck uc = new UnameCheck("shopping","root","",uName);
		uc.doRead();
		if(uc.check() && password.length()<6){
			AddQuery aq = new AddQuery("shopping","root","");
			aq.doAdd(fName, lName, uName, email, password);
			
			String url = "/index.jsp";
			request.setAttribute("Sign-up Success!!","error");
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request,response);
		}
		else{
			String url = "/index.jsp";
			request.setAttribute("UserName or Password error!","error");
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request,response);
		}
		
		
	}

}
