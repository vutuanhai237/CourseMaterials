package strategy;

public class Client {
	public static void main(String args[]) {
		RouteStrategy bicycleRoute = new BicycleRoute();
		RouteStrategy planeRoute = new PlaneRoute();
		Navigation navigation = new Navigation(bicycleRoute);
		System.out.println(navigation.getRoute("Quan 1", "Quan 2"));
		System.out.println("Change to other route");
		navigation.setRoute(planeRoute);
		System.out.println(navigation.getRoute("Quan 1", "Quan 2"));
	}
}
