package dao;

import java.sql.SQLException;

import pojos.Team;

public interface TeamDao {
	public String addTeam(Team newTeam) throws SQLException;

	public int getTeamId(String abbrevation) throws SQLException;

	public boolean validatePlayerForTeam(String dob, double battingAvg, int wicketsTaken, String abbreviation)
			throws SQLException;

}
