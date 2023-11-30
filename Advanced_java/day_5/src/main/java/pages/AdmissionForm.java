package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Course;
import pojos.Student;

/**
 * Servlet implementation class AdmissionForm
 */
@WebServlet("/admission")
public class AdmissionForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmissionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter()) {
			String firstName = request.getParameter("fn");
			String lastName = request.getParameter("ln");
			int score = Integer.parseInt(request.getParameter("score"));
			Course course = Course.valueOf(request.getParameter("course").toUpperCase());
			
			Student newStudent=new Student(firstName, lastName, score, course);
			
			if(score >= course.getMarks())
				newStudent.setAdmissionStatus(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
