package StudentCRUDObjectify;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Objectify;

/**
 * Servlet implementation class StudentController
 */
@WebServlet(name = "StudentController", urlPatterns = {"/"})
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentController() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		try {
			if (action.equals("/register")) {
				newStdForm(request, response);
			} else if (action.equals("/insert")) {
				addNewStd(request, response);
			} else if (action.equals("/edit")) {
				editStdForm(request, response);
			} else if (action.equals("/update")) {
				updateStdData(request, response);
			} else if (action.equals("/delete")) {
				deleteStdData(request, response);
			} else {
				listOfStds(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void newStdForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/StudentEntryForm.jsp").forward(request, response);
	}
	private void listOfStds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Objectify ofy= OfyFact.init();
		java.util.List<Student> allStudents = ofy.load().type(Student.class).list();
		System.out.println(allStudents);
		request.setAttribute("listOfAllStudents", allStudents);
		request.getRequestDispatcher("/WEB-INF/views/AllStudentsPage.jsp").forward(request, response);
	}
	private void addNewStd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("stdName");
		String email = request.getParameter("stdEmail");
		String city = request.getParameter("stdCity");
		Student student = new Student(name, email, city);
		System.out.println(student);
		Objectify ofy= OfyFact.init();
		ofy.save().entities(student).now();	
		request.getRequestDispatcher("/WEB-INF/views/StudentEntryForm.jsp").forward(request, response);
	}
	private void editStdForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Objectify ofy= OfyFact.init();
		Student stdToBeEdit= ofy.load().type(Student.class).id(id).now();
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/StudentUpdateForm.jsp");
		request.setAttribute("stdToBeEdit", stdToBeEdit);
		requestDispatcher.forward(request, response);
	}
	private void updateStdData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long id = Long.parseLong(request.getParameter("stdId"));
		String newName = request.getParameter("newStdName");
		String newEmail = request.getParameter("newStdEmail");
		String newCity = request.getParameter("newstdCity");
		Student stdUpdated = new Student(id, newName, newEmail, newCity);
		System.out.println(stdUpdated);
		Objectify ofy= OfyFact.init();
		ofy.save().entities(stdUpdated).now();	
		response.sendRedirect("/StudentController");
	}
	private void deleteStdData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Objectify ofy= OfyFact.init();
		Student stdToDelete= ofy.load().type(Student.class).id(id).now();
		ofy.delete().entity(stdToDelete).now();
		response.sendRedirect("/StudentController");
	}
}
