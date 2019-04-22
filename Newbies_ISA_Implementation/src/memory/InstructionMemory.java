package memory;

public class InstructionMemory {

	public static int[] instructions = new int[4096];
	public static int numberOfInstructions;

	public static void setInstruction(int i, int value) {
		instructions[i / 2] = value;
		numberOfInstructions++;
	}

	public static int getInstruction(int i) {
		return instructions[i / 2];
	}

	public int getNumberOfInstructions() {
		return numberOfInstructions;
	}

}
