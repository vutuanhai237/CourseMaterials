package prototype;

public class Client {

	public static void main(String[] args) {
		// Initialize cake
		Cake cake = new Cake();
		cake.addCandle(new Candle("red"));
		cake.addCandle(new Candle("blue"));
		cake.addEgg(new Egg(2));
		cake.addEgg(new Egg(3));
		// Clone cake
		Cake clonedCake = cake.clone();
		clonedCake.setName("Cloned cake");
		// Show output
		System.out.println(cake.toString());
		System.out.println(clonedCake.toString());
		
	}

}
