package prototype;
import java.util.ArrayList;

public class Cake implements Cloneable{
	private String name;
	private ArrayList<Candle> candles = new ArrayList<Candle>();
	private ArrayList<Egg> eggs = new ArrayList<Egg>();
	public Cake() {
		this.setName("Cake");
		System.out.println("[INFO] cake was created");
	}
	
	public Cake(ArrayList<Candle> candles, ArrayList<Egg> eggs) {
		this.candles = candles;
		this.eggs = eggs;
	}
	
	public void addCandle(Candle candle) {
		this.candles.add(candle);
	}
	
	public void setCandle(Candle candle) {
		this.candles.clear();
		this.candles.add(candle);
	}
	
	public void addEgg(Egg egg) {
		this.eggs.add(egg);
	}
	public ArrayList<Candle> getCandles() {
		return candles;
	}
	public void setCandles(ArrayList<Candle> candles) {
		this.candles = candles;
	}
	public ArrayList<Egg> getEggs() {
		return eggs;
	}
	public void setEggs(ArrayList<Egg> eggs) {
		this.eggs = eggs;
	}

	@Override
    protected Cake clone() {
        try {
            return (Cake) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public String toString() {
		String result = "[" + name + "] ";
		for (Candle candle: this.candles) {
			result += "Candle: " + candle.getColor() + ", ";
		}
		for (Egg egg: this.eggs) {
			result += "Egg: " + egg.getSize() + ", ";
		}
		return result;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
