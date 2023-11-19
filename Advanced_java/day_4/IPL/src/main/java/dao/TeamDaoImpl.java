package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import pojos.Team;
import utils.DbUtils;

public class TeamDaoImpl implements TeamDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3;

	public TeamDaoImpl() throws SQLException {
		cn = DbUtils.openConnection();
		pst1 = cn.prepareStatement("insert into teams values(default,?,?,?,?,?,?)");
		pst2 = cn.prepareStatement("select max_age,batting_avg,wickets_taken from teams where team_id = ?");
		pst3 = cn.prepareStatement("select team_id from teams where abbrevation = ?");
	}

	@Override
	public String addTeam(Team newTeam) throws SQLException {
		pst1.setString(1, newTeam.getName());
		pst1.setString(2, newTeam.getAbbrevation());
		pst1.setString(3, newTeam.getOwner());
		pst1.setInt(4, newTeam.getMax_age());
		pst1.setDouble(5, newTeam.getMinBattingAvg());
		pst1.setInt(6, newTeam.getMinWicketsTaken());

		if (pst1.executeUpdate() == 1)
			return "Team Successfully added";

		return "Team registration failed";
	}

	@Override
	public boolean validatePlayerForTeam(String dob, double battingAvg, int wicketsTaken, String abbrevation)
			throws SQLException {
		int age = calculateAge(dob);
		int teamId = getTeamId(abbrevation);

		System.out.println("Hello");
		pst2.setInt(1, teamId);
		ResultSet rst = pst2.executeQuery();
		if (rst.next()) {
			System.out.println("Hello");
			double minBattingAvg;
			int maxAge, minWicketsTaken;
			maxAge = rst.getInt(1);
			minBattingAvg = rst.getDouble(2);
			minWicketsTaken = rst.getInt(3);

			if (age < maxAge && battingAvg > minBattingAvg && wicketsTaken > minWicketsTaken) {
				return true;
			}
		}

		return false;
	}

	@Override
	public int getTeamId(String abbrevation) throws SQLException {
		pst3.setString(1, abbrevation);

		ResultSet rst = pst3.executeQuery();
		if (rst.next()) {
			int teamId;
			teamId = rst.getInt(1);
			return teamId;
		}
		return 0;
	}

	public int calculateAge(String dob) {
		LocalDate dob1 = LocalDate.parse(dob);
		LocalDate currDate = LocalDate.now();

		int age = Period.between(dob1, currDate).getYears();
		return age;
	}

}
