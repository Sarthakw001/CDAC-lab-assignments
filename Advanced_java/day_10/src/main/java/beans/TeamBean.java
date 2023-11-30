package beans;
//Dependent : TeamBean , it's dependency : TeamDao

import java.util.List;

import dao.TeamDao;
import dao.TeamDaoImpl;

public class TeamBean {
	
	private TeamDao teamDao;
	
	public TeamBean() {
		// create a dependency
		teamDao=new TeamDaoImpl();
		System.out.println("Team bean and team dao created....");
	}
	//Business Logic to fetch abbreviations of all teams
	public List<String> fetchTeamsAbbreviations() 
	{
		return teamDao.getAllTeamsAbbreviations();
	}
	
}
