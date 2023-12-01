package beans;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import dao.UserDaoImpl;
import pojos.User;

public class UserBean {

	private UserDaoImpl userDao;// dependency
	private User userDetails;// result
	// clnt info
	private String email;
	private String pass;
	private String fname;
	private String lname;
	private String dob;
	//add another property to store the status mesg
	private String message;

	// def ctor
	public UserBean() throws SQLException {
		// create user dao instance
		userDao = new UserDaoImpl();
		System.out.println("user bean created...");
	}

	// generate getter n setter
	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	

	public String getMessage() {
		return message;
	}

	//add a Business logic method to authenticate user
	public String authenticateUser() throws SQLException {
		System.out.println("in JB B.L auth user " + email + " " + pass);
		// JB ---> DAo's method
		userDetails = userDao.authenticateUser(email, pass);
		if (userDetails == null) // => invalid login
		{
			message="Invalid login , pls retry!";
			return "login";
		}
		//=> login successful
		message="successful login!";
		if(userDetails.getRole().equals("admin"))
			return "admin_page";
		//=> voter 
		if(userDetails.isVotingStatus())
			return "logout";
		//=> voter not yet voter
		return "candidate_list";
	}
	//add Business Logic method  to add a new voter
	public String registerNewVoter() throws SQLException{
		
		LocalDate date=LocalDate.parse(dob);
		int age=Period.between(date, LocalDate.now()).getYears();
		if(age >= 21)
		{
			//firstName, String lastName, String email, String password, Date dob
			User user=new User(fname, lname, email, pass, Date.valueOf(date));
			//invoke dao's method for persistence(insert)
			user.setRole("voter");			
			return userDao.registerNewVoter(user);
		}
		else 
			return "Voter reg failed : invalid age !!!!!!!!!!";
	}

}
