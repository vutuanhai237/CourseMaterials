package state;

public class Document {
	public State state;
	public boolean isPublished = false;
	
	public Document() {}
	public Document(State state) {
		this.state = state;
	}
	public void changeState(State state) {
		this.state = state;
	}
	public void render() {
		this.state.render();
	}
	public void publish() {
		this.state.publish();
	}
	
	public void setIsPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}
	public boolean getIsPublished() {
		return this.isPublished;
	}
	
}
