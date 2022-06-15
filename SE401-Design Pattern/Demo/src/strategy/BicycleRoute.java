package strategy;

public class BicycleRoute implements RouteStrategy{

	@Override
	public String getRoute(String A, String B) {
		return A + " go to " + B + " by Bicycle";
	}

	@Override
	public String getStrategy() {
		return "Bicycle Strategy";
	}

}
