package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeamDaoImpl;
import pojos.Team;

/**
 * Servlet implementation class TeamRegistration
 */
@WebServlet("/TeamRegistration")
public class TeamRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamDaoImpl td;

	public TeamRegistration() throws SQLException {
		td = new TeamDaoImpl();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String teamName = request.getParameter("teamName");
		String abbrevation = getAbbrevation(teamName);
		String owner = request.getParameter("owner");
		int age = Integer.parseInt(request.getParameter("age"));
		double battingAvg = Double.parseDouble(request.getParameter("battingAvg"));
		int minWickets = Integer.parseInt(request.getParameter("minWickets"));

		try (PrintWriter pw = response.getWriter()) {
			String res = td.addTeam(new Team(teamName, abbrevation, owner, age, battingAvg, minWickets));
			pw.print("<h1>" + res + "</h1>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getAbbrevation(String teamName) {
		String[] abb = teamName.trim().split(" ");
		String ans = "";
		for (int i = 0; i < abb.length; i++) {
			ans = ans + abb[i].charAt(0);
		}
		return ans.toUpperCase();
	}

}
