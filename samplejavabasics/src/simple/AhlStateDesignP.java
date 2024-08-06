package simple;

public class AhlStateDesignP {
	public static void main(String[] args) {
		Document document = new Document();

		// Document in draft state
		document.applyState();

		// Change state to moderation
		document.setState(new ModerationState());
		document.applyState();

		// Change state to published
		document.setState(new PublishedState());
		document.applyState();
	}
}
//State interface
interface State {
	void handleRequest();
}

//Concrete States
class DraftState implements State {
	@Override
	public void handleRequest() {
		System.out.println("Document is in draft state.");
	}
}

class ModerationState implements State {
	@Override
	public void handleRequest() {
		System.out.println("Document is in moderation state.");
	}
}

class PublishedState implements State {
	@Override
	public void handleRequest() {
		System.out.println("Document is published.");
	}
}

//Context
class Document {
	private State currentState;

	public Document() {
		// Initial state
		currentState = new DraftState();
	}

	public void setState(State state) {
		currentState = state;
	}

	public void applyState() {
		currentState.handleRequest();
	}
}
