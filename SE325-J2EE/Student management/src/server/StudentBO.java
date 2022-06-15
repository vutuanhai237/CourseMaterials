package server;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.ListStudent;
import model.Score;
import model.Student;

public class StudentBO {
	private static Logger LOGGER = LogManager.getLogger(ListStudent.class);

	public static ListStudent getSampleStudent() {
		Score math = new Score("math", 5.0);
		Score english = new Score("english", 9.0);
		Score physical = new Score("physical", 9.0);
		ArrayList<Score> scores = new ArrayList<Score>();
		scores.add(math);
		scores.add(english);
		scores.add(physical);
		Student student1 = new Student("Hai1", 18, "12C1", "Gia Lai", scores);
		Student student2 = new Student("Hai2", 18, "12C1", "Gia Lai", scores);
		ListStudent listStudent = new ListStudent();
		listStudent.addStudent(student1);
		listStudent.addStudent(student2);

		LOGGER.info("Get smaple student successfully");
		return listStudent;
	}

	public static String checkStudent(String name, int age, String classes, String province, double mathScore,
			double englishScore, double physicalScore) {
		String message = "valid";
		if (name.length() > 30) {
			message = "Name was tool long!";
		} else if (age < 0 || age > 100) {
			message = "Age is not valid";
		} else if (classes.length() < 1 || classes.length() > 10) {
			message = "Class 's name is not valid";
		} else if (mathScore < 0 || mathScore > 10) {
			message = "Math score is not valid";
		} else if (englishScore < 0 || englishScore > 10) {
			message = "English score is not valid";
		} else if (physicalScore < 0 || physicalScore > 10) {
			message = "Physical score is not valid";
		}
		return message;
	}
}
