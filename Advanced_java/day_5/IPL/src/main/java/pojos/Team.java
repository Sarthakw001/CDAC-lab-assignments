package pojos;

public class Team {
	private int teamId;
	private String teamName;
	private String abbrevation;
	private String owner;
	private int maxAge;
	private double minBattingAvg;
	private int minWicketsTaken;
	
	public Team(String teamName, String abbrevation, String owner, int max_age, double minBattingAvg, int minWicketsTaken) {
		super();
		this.teamName = teamName;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.maxAge = max_age;
		this.minBattingAvg = minBattingAvg;
		this.minWicketsTaken = minWicketsTaken;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return teamName;
	}

	public void setName(String teamName) {
		this.teamName = teamName;
	}

	public String getAbbrevation() {
		return abbrevation;
	}

	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMax_age() {
		return maxAge;
	}

	public void setMax_age(int max_age) {
		this.maxAge = max_age;
	}

	public double getMinBattingAvg() {
		return minBattingAvg;
	}

	public void setMinBattingAvg(double minBattingAvg) {
		this.minBattingAvg = minBattingAvg;
	}

	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}

	public void setMinWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}
	
}
