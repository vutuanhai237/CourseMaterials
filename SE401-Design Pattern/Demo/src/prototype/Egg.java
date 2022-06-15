package prototype;

public class Egg {
	private int size;
	public Egg(int size) {
		this.size = size;
		System.out.println("[INFO] " + size + " egg was created");
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
