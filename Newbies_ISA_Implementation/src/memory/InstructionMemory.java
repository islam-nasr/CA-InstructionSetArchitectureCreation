package memory;

public class InstructionMemory {

	public static int[] instructions=new int[4096];
	int numberOfInstructions;

//	public InstructionMemory(int size) {
//		instructions = new int[size];
//	}

	public void setInstruction(int i, int value) {
		instructions[i / 2] = value;
		numberOfInstructions++;
	}

	public int getInstruction(int i) {
		return instructions[i / 2];
	}

	public int getNumberOfInstructions() {
		return numberOfInstructions;
	}

}
