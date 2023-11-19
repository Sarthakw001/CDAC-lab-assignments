package dao;

import java.sql.SQLException;

import pojos.Player;

public interface PlayerDao {
	public String addPlayerToTeam(Player newPlayer) throws SQLException;
}
