package proxy;

public class RealInternet implements Internet {

	@Override
	public void connect(String host) {
		System.out.println("Connect to " + host + " successfully!");
	}

}
