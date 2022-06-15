package prototype;

public class Candle {
	private String color;
	public Candle(String color) {
		this.setColor(color);
		System.out.println("[INFO] " + color + " candle was created");
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
