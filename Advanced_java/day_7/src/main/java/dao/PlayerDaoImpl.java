package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;
import pojos.Team;
import static utils.HibernateUtils.getFactory;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addPlayerDetails(Player player, Integer teamId) {
		String mesg = "adding player to the team failed....";
		//get Session from SF
		Session session = getFactory().getCurrentSession();
		//Begin transaction
		Transaction tx = session.beginTransaction();
		try {
			//get team by it's id
			Team team = session.get(Team.class, teamId);
			if (team != null) {
					
				team.addPlayer(player);
				mesg="Added player to the team....";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}
}
