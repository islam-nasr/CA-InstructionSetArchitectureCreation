package stages;

import java.util.HashMap;

public class InstructionIntialization {
	// HashMap <BitSet,BitSet> bitInstructions;
	public static HashMap<String, Integer> bitStrings = new HashMap<String, Integer>();
	public static HashMap<String, String> StringType = new HashMap<String, String>();

	public static void initialize() {
		String init = "RDI";
		int initBits = 0;
		StringType.put(init, "I");
		bitStrings.put(init, initBits);
		init = "RD";
		initBits++;
		StringType.put(init, "R");
		bitStrings.put(init, initBits);
		init = "WR";
		initBits++;
		StringType.put(init, "R");
		bitStrings.put(init, initBits);
		init = "SUM";
		initBits++;
		StringType.put(init, "R");
		bitStrings.put(init, initBits);
		init = "DIFF";
		initBits++;
		StringType.put(init, "R");
		bitStrings.put(init, initBits);
		init = "AND";
		initBits++;
		StringType.put(init, "R");
		bitStrings.put(init, initBits);
		init = "OR";
		initBits++;
		StringType.put(init, "R");
		bitStrings.put(init, initBits);
		init = "NOT";
		initBits++;
		StringType.put(init, "R");
		bitStrings.put(init, initBits);
		init = "HOP";
		initBits++;
		StringType.put(init, "J");
		bitStrings.put(init, initBits);
		init = "HOPR";
		initBits++;
		StringType.put(init, "R");
		bitStrings.put(init, initBits);
		init = "HAT";
		initBits++;
		StringType.put(init, "R");
		bitStrings.put(init, initBits);
		init = "SMN";
		initBits++;
		StringType.put(init, "R");
		bitStrings.put(init, initBits);
		init = "SMX";
		initBits++;
		StringType.put(init, "R");
		bitStrings.put(init, initBits);
		init = "SLT";
		initBits++;
		StringType.put(init, "R");
		bitStrings.put(init, initBits);
		init = "SLL";
		initBits++;
		StringType.put(init, "I");
		bitStrings.put(init, initBits);
		init = "SKP";
		initBits++;
		StringType.put(init, "R");
		bitStrings.put(init, initBits);

	}

	/*
	 * public static void printing() {
	 * 
	 * System.out.println(bitStrings.get("RDI"));
	 * System.out.println(bitStrings.get("RD"));
	 * System.out.println(bitStrings.get("WR"));
	 * System.out.println(bitStrings.get("SUM"));
	 * System.out.println(bitStrings.get("DIFF"));
	 * System.out.println(bitStrings.get("AND"));
	 * System.out.println(bitStrings.get("OR"));
	 * System.out.println(bitStrings.get("NOT"));
	 * System.out.println(bitStrings.get("HOP"));
	 * System.out.println(bitStrings.get("HOPR"));
	 * System.out.println(bitStrings.get("HAT"));
	 * System.out.println(bitStrings.get("SMN"));
	 * System.out.println(bitStrings.get("SMX"));
	 * System.out.println(bitStrings.get("SLT"));
	 * System.out.println(bitStrings.get("SLL"));
	 * System.out.println(bitStrings.get("SKP"));
	 * 
	 * }
	 * 
	 * public static void main(String[] args) { initialize(); printing(); }
	 */

}
