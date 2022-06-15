package state;

public class PublishedState extends State{

	public PublishedState(Document document) {
		super(document);
		this.document.setIsPublished(true);
	}

	@Override
	public void render() {
		System.out.println("Published document is rendering!");
	}


}
