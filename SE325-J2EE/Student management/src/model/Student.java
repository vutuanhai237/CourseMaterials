package model;

import java.util.ArrayList;

public class Student {
	private String name;
	private int age;
	private String classes;
	private String province;
	private ArrayList<Score> scores;
	@SuppressWarnings("unused")
	private double GPA;

	public Student() {
		this.name = "";
		this.age = 0;
		this.classes = "";
		this.province = "";
		this.scores = new ArrayList<Score>();
		this.GPA = 0.0;
	}

	public Student(String name, int age, String classes, String province, ArrayList<Score> scores) {
		this.name = name;
		this.age = age;
		this.classes = classes;
		this.province = province;
		this.scores = scores;
		this.GPA = this.getGPA();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGPA() {
		double gpa = 0;
		for (Score score : this.scores) {
			gpa += score.getPoint();
		}
		return gpa / this.scores.size();
	}

	public void setGPA(double GPA) {
		this.GPA = GPA;
	}

	public ArrayList<Score> getScores() {
		return scores;
	}

	public void setScores(ArrayList<Score> scores) {
		this.scores = scores;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}
