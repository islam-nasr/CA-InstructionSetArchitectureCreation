package memory;

public class InstructionMemory {

	public static int[] instructions = new int[4096];
	public static int numberOfInstructions;

	// public InstructionMemory(int size) {
	// instructions = new int[size];
	// }

	/***
	 * sets instruction into the instruction memory
	 * 
	 * @param i
	 *            location being inserted at
	 * @param value
	 *            number inserted in that location
	 * 
	 */
	public static void setInstruction(int i, int value) {
		instructions[i / 2] = value;
		numberOfInstructions++;
	}

	/***
	 * gets instruction from the instruction memory
	 * 
	 * @param i
	 *            location being fetched
	 * 
	 */
	public static int getInstruction(int i) {
		return instructions[i / 2];
	}

	/***
	 * gets the number of instructions inserted into the instruction memory
	 * 
	 */
	public int getNumberOfInstructions() {
		return numberOfInstructions;
	}

}
