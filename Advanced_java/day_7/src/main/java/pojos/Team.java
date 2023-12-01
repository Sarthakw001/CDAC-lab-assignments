package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity {
	@Column(length = 100)
	private String name;
	@Column(length = 10)
	private String abbreviation;
	@Column(length = 20)
	private String owner;
	@Column(name = "max_age")
	private int maxAge;
	@Column(name = "batting_avg")
	private double battingAvg;
	@Column(name = "wickets_taken")
	private int wicketsTaken;
	//associate property
	//Team 1--->* Player
	@OneToMany(mappedBy = "myTeam", 
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Player> players = new ArrayList<>();

	public Team() {
		// TODO Auto-generated constructor stub
	}

	public Team(int teamId, String name, String abbreviation, String owner, int maxAge, double battingAvg,
			int wicketsTaken) {
		super();

		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getabbreviation() {
		return abbreviation;
	}

	public void setabbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	//Helper method to establish a bi-directional link between Team and player
	public void addPlayer(Player p) {
		players.add(p);
		p.setMyTeam(this);
	}

	//Helper method to un-establish a bi-directional link between Team and player
	public void removePlayer(Player p) {
		players.remove(p);
		p.setMyTeam(null);
	}

	@Override
	public String toString() {
		return "Team [teamId=" + getId() + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}

}
