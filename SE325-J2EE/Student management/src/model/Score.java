package model;

public class Score {
	private String name;
	private double point;

	public Score(String name, double point) {
		this.name = name;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPoint() {
		return this.point;
	}

	public void setPoint(double score) {
		this.point = score;
	}

	public String getString() {
		return this.name + ": " + this.point;
	}
}
