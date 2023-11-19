package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.User;
import utils.DBUtils;

public class UserDaoImpl implements UserDao {

	private Connection cn;
	private PreparedStatement pst1, pst2, pst3, pst4,pst5;

	public UserDaoImpl() throws SQLException {
		cn = DBUtils.openConnection();
		pst1 = cn.prepareStatement(
				"select first_name,last_name,dob,status from users where role = ? and date between ? and ?");
		pst2 = cn.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
		pst3 = cn.prepareStatement("delete from users where id = ?");
		pst4 = cn.prepareStatement("select * from users where email = ? and password = ?");
		pst5 = cn.prepareStatement("select * from users");
	}

	@Override
	public List<User> getSelectedUsers(String role, Date begin, Date end) throws SQLException {
		pst1.setString(1, role);
		pst1.setDate(2, begin);
		pst1.setDate(3, end);
		List<User> users = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next()) {
				users.add(new User(rst.getString(1), rst.getString(2), rst.getDate(3), rst.getBoolean(4)));
			}
		}
		return users;
	}

	@Override
	public String registerNewVoter(User newVoter) throws SQLException {
		pst2.setString(1, newVoter.getFirstName());
		pst2.setString(2, newVoter.getLastName());
		pst2.setString(3, newVoter.getEmail());
		pst2.setString(4, newVoter.getPassword());
		pst2.setDate(5, newVoter.getDob());
		pst2.setBoolean(6, false);
		pst2.setString(7, "voter");

		int rowCount = pst2.executeUpdate();
		if (rowCount == 1)
			return "Voter Registered";
		return "Voter Registration failed";
	}

	@Override
	public String deleteUserDetails(int userId) throws SQLException {
		pst3.setInt(1, userId);
		if (pst3.executeUpdate() == 1)
			return "User deleted";
		return "User not deleted";
	}

	@Override
	public User authenticateUser(String email, String pwd) throws SQLException {
		pst4.setString(1, email);
		pst4.setString(2, pwd);

		try (ResultSet rst = pst4.executeQuery()) {
			if (rst.next()) {
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), email, rst.getDate(6),
						rst.getBoolean(7), rst.getString(8));
			}
		}
		return null;
	}
	
	@Override
	public List<User> getAllCandidate() throws SQLException{
		
		List<User> users = new ArrayList<>();
		try(ResultSet rst = pst5.executeQuery()){
			while(rst.next()) {
				users.add(new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDate(6),
						rst.getBoolean(7), rst.getString(8)));
			}
		}
		return users;
	}
	
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		DBUtils.closeConnection();
		System.out.println("user dao cleaned up !");
	}

}
