package state;

public class Client {
	public static void main(String args[]) {
		Document document = new Document();
		document.changeState(new DraftState(document));
		document.render();
		document.publish();
		System.out.println("Document was changed its state");
		document.changeState(new PublishedState(document));
		document.render();
		document.publish();
	}
	
}
