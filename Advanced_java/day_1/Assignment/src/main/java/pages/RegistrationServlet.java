package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDaoImpl;
import pojos.User;


@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImpl usd;

	
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("first_name");
		String lastName  = request.getParameter("last_name");
		String email  = request.getParameter("email");
		String password  = request.getParameter("password");
		String dob = request.getParameter("dob");
		
		if(isValidAge(dob)) {
			try {
				usd.registerNewVoter(new User(firstName,lastName,email,password,Date.valueOf(dob)));
				out.print("<h1>Voter Registered..........</a></h1>");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			out.print("<h1>Voter registration failed.............Try again</h1>");
		}
	}

	private boolean isValidAge(String dob) {
		
		LocalDate dob1 = LocalDate.parse(dob);
		LocalDate currDate = LocalDate.now();
		
		int age = Period.between(dob1, currDate).getYears();
		if(age >= 18){
			return true;
		}
		return false;
	}
}
