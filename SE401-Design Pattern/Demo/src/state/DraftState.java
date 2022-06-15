package state;

public class DraftState extends State{
	public DraftState(Document document) {
		super(document);
	}

	@Override
	public void render() {
		System.out.println("Draft document is rendering!");
	}

}
