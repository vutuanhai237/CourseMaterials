package state;

public abstract class State {
	public Document document;
	public State() {
	
	}
	public State(Document document) {
		this.document = document;
	}
	public abstract void render();
	public void publish() {
		System.out.println("Document is published: " + this.document.getIsPublished());
	};
}
