package pages;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImpl usd;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		try {
			usd = new UserDaoImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("first_name");
		String lastName  = request.getParameter("last_name");
		String email  = request.getParameter("email");
		String password  = request.getParameter("password");
		String dob = request.getParameter("dob");
		
		if(isValidAge(dob)) {
			try {
				usd.registerNewVoter(new User(firstName,lastName,email,password,Date.valueOf(dob)));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean isValidAge(String dob) {
		
	}

}
