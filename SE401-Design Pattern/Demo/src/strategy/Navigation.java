package strategy;

public class Navigation {
	private RouteStrategy route;
	public Navigation(RouteStrategy route) {
		this.setRoute(route);
	}
	public RouteStrategy getRoute() {
		return route;
	}
	public void setRoute(RouteStrategy route) {
		this.route = route;
	}
	
	public String getRoute(String A, String B) {
		return (this.route.getStrategy()) + "\n" + (this.route.getRoute(A, B));
	}
}
