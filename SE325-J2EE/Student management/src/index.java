import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.ListStudent;
import model.Score;
import model.Student;
import server.StudentBO;
import utils.Utils.JSONUtils;

@WebServlet(description = "handle for index.jsp", urlPatterns = { "/index" })
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ListStudent listStudent = new ListStudent();
	private static Logger LOGGER = LogManager.getLogger(ListStudent.class);

	// Initialize some example
	public index() {
		super();
		listStudent = StudentBO.getSampleStudent();
	}

	// Fetching data when initialize JSP
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("listStudent", String.valueOf(JSONUtils.getJSON(this.listStudent)));
		request.getRequestDispatcher("index.jsp").forward(request, response);
		LOGGER.info("Get list student successfully");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Add new student
		String name = request.getParameter("studentNameInput");
		int age = Integer.parseInt(request.getParameter("studentAgeInput"));
		String classes = request.getParameter("studentClassesInput");
		String province = request.getParameter("studentProvinceInput");
		double mathScore = Double.parseDouble(request.getParameter("mathScoreInput"));
		double englishScore = Double.parseDouble(request.getParameter("englishScoreInput"));
		double physicalScore = Double.parseDouble(request.getParameter("physicalScoreInput"));
		try (PrintWriter out = response.getWriter()) {
			String message = StudentBO.checkStudent(name, age, classes, province, mathScore, englishScore,
					physicalScore);
			if (message == "valid") {
				ArrayList<Score> newScores = new ArrayList<Score>();
				newScores.add(new Score("math", mathScore));
				newScores.add(new Score("english", englishScore));
				newScores.add(new Score("physical", physicalScore));
				listStudent.addStudent(new Student(name, age, classes, province, newScores));
				out.println(name + " is added successfully");
				LOGGER.info(name + " is added successfully");
			} else {
				out.println(message + ", please try again!");
				LOGGER.error(message + ", please try again!");
			}
		}
	}

}
