package strategy;

public class PlaneRoute implements RouteStrategy {

	@Override
	public String getRoute(String A, String B) {
		return A + " go to " + B + " by Plane";	
	}

	@Override
	public String getStrategy() {
		return "Plane Strategy";
	}

}
