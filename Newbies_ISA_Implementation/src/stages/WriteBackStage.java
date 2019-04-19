package stages;

public class WriteBackStage extends Stage {
	String name = "WB";

	public WriteBackStage() {
		super();
	}

	public void execute() {
		System.out.println("Executing WriteBackStage....");
	}

}
