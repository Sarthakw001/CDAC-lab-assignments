package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;
import pojos.Player;

/**
 * Servlet implementation class PlayerRegistration
 */
@WebServlet("/PlayerRegistration")
public class PlayerRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamDaoImpl td;
	private PlayerDaoImpl pd;

	public PlayerRegistration() throws SQLException {
		td = new TeamDaoImpl();
		pd = new PlayerDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String abbrevation = request.getParameter("abbrevation");
		String firstName = request.getParameter("name");
		String dob = request.getParameter("dob");
		double battingAvg = Double.parseDouble(request.getParameter("battingAvg"));
		int wicketsTaken = Integer.parseInt(request.getParameter("wicketsTaken"));

		try (PrintWriter pw = response.getWriter()) {
			if (td.validatePlayerForTeam(dob,battingAvg, wicketsTaken, abbrevation)) {
				int teamId = td.getTeamId(abbrevation);
				String res = pd.addPlayerToTeam(
						new Player(firstName, Date.valueOf(dob), battingAvg, wicketsTaken, teamId));
				pw.println("<h1>"+ res +"</h1>");
			}else {
				pw.println("<h1>Player not eligible</h1>");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
