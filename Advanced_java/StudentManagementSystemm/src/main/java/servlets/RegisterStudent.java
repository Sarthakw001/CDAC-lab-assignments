package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDaoImpl;
import pojos.Student;

/**
 * Servlet implementation class RegisterStudent
 */
public class RegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDaoImpl sd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterStudent() {
        super();
        sd = new StudentDaoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String f_name = request.getParameter("fn");
		String l_name = request.getParameter("ln");
		String city = request.getParameter("city");
		String course = request.getParameter("course");
		
		Student st = new Student(f_name,l_name,city,course);
		sd.addStudent(st);
		
		PrintWriter out = response.getWriter();
		out.print("<h1>Student Created</h1>");
	}

}
