package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pojos.Player;
import utils.DbUtils;

public class PlayerDaoImpl implements PlayerDao {
	private Connection cn;
	private PreparedStatement pst1;

	public PlayerDaoImpl() throws SQLException {
		cn = DbUtils.openConnection();
		pst1 = cn.prepareStatement("insert into players values (default,?,?,?,?,?)");

	}

	@Override
	public String addPlayerToTeam(Player newPlayer) throws SQLException {
		pst1.setString(1, newPlayer.getFirstName());
		pst1.setDate(2, newPlayer.getDob());
		pst1.setDouble(3, newPlayer.getBattingAvg());
		pst1.setInt(4, newPlayer.getWicketsTaken());
		pst1.setInt(5, newPlayer.getTeamId());

		if (pst1.executeUpdate() == 1) {
			return "Player registration successful";
		}

		return "Player registration failed";
	}

}
