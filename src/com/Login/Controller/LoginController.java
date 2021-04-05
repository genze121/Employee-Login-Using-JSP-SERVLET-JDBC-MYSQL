package com.Login.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Login.DAO.EmployeeLoginDAO;
import com.Login.Entity.EmployeeLogin;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeLoginDAO loginDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		loginDAO = new EmployeeLoginDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email_");
		String password = request.getParameter("password_");

		EmployeeLogin login = new EmployeeLogin();
		login.setEmail(email);
		login.setPassword(password);

		login = loginDAO.getLoginDetails(login);
		if (login == null) {
			System.out.println("Something went wrong!!!");

		} else {
			System.out.println("Login Successfully Done!!!");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
		dispatcher.forward(request, response);
	}

}
