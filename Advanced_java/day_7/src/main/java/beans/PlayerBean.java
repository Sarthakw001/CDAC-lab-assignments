package beans;

import java.time.LocalDate;
import java.time.Period;

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

public class PlayerBean {
	//clnt's conversational state
	private String myTeam;
	private String fn;
	private String ln;
	private String dob;
	private double avg;
	private int wickets;
	private String message;
	
	//team dao , player dao
	private TeamDao teamDao;
	private PlayerDao playerDao;

	public PlayerBean() {
		teamDao = new TeamDaoImpl();
		playerDao = new PlayerDaoImpl();
	}

	public String getMyTeam() {
		return myTeam;
	}

	public void setMyTeam(String myTeam) {
		this.myTeam = myTeam;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public TeamDao getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public PlayerDao getPlayerDao() {
		return playerDao;
	}

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	
	public String getMessage() {
		return message;
	}

	//add Business Logic method to validate and add player details
	public String validateAndAddPlayer() {
		
		//get team details by it's abbreviation.
		Team team=teamDao.getDetailsByAbbreviation(myTeam);
		//validation logic
		if(calculateDob(dob) > team.getMaxAge()|| avg < team.getBattingAvg() || wickets< team.getWicketsTaken())
		{
			message="Player details Invalid ....";
			return message;
		}
		//=> valid details -->create transient player
		Player player=new Player(fn, ln, LocalDate.parse(dob), avg, wickets);
		message=playerDao.addPlayerDetails(player, team.getId());
		return message;
	}
	
	//method to calculate age
	private int calculateDob(String dob) {
		
		LocalDate date = LocalDate.parse(dob);
		int age=Period.between(date, LocalDate.now()).getYears();
		
		return age;
		
	}
}
