package stages;

import java.util.HashMap;

public class InstructionIntialization {
	// HashMap <BitSet,BitSet> bitInstructions;
	public static HashMap<String, Integer> bitStrings = new HashMap<String, Integer>();

	public static void initialize() {
		String init = "RDI";
		int initBits = 0;
		bitStrings.put(init, initBits);
		init = "RD";
		initBits++;
		bitStrings.put(init, initBits);
		init = "WR";
		initBits++;
		bitStrings.put(init, initBits);
		init = "SUM";
		initBits++;
		bitStrings.put(init, initBits);
		init = "DIFF";
		initBits++;
		bitStrings.put(init, initBits);
		init = "AND";
		initBits++;
		bitStrings.put(init, initBits);
		init = "OR";
		initBits++;
		bitStrings.put(init, initBits);
		init = "NOT";
		initBits++;
		bitStrings.put(init, initBits);
		init = "HOP";
		initBits++;
		bitStrings.put(init, initBits);
		init = "HOPR";
		initBits++;
		bitStrings.put(init, initBits);
		init = "HAT";
		initBits++;
		bitStrings.put(init, initBits);
		init = "SMN";
		initBits++;
		bitStrings.put(init, initBits);
		init = "SMX";
		initBits++;
		bitStrings.put(init, initBits);
		init = "SLT";
		initBits++;
		bitStrings.put(init, initBits);
		init = "SLL";
		initBits++;
		bitStrings.put(init, initBits);
		init = "SKP";
		initBits++;
		bitStrings.put(init, initBits);

	}

/*	public static void printing() {

		System.out.println(bitStrings.get("RDI"));
		System.out.println(bitStrings.get("RD"));
		System.out.println(bitStrings.get("WR"));
		System.out.println(bitStrings.get("SUM"));
		System.out.println(bitStrings.get("DIFF"));
		System.out.println(bitStrings.get("AND"));
		System.out.println(bitStrings.get("OR"));
		System.out.println(bitStrings.get("NOT"));
		System.out.println(bitStrings.get("HOP"));
		System.out.println(bitStrings.get("HOPR"));
		System.out.println(bitStrings.get("HAT"));
		System.out.println(bitStrings.get("SMN"));
		System.out.println(bitStrings.get("SMX"));
		System.out.println(bitStrings.get("SLT"));
		System.out.println(bitStrings.get("SLL"));
		System.out.println(bitStrings.get("SKP"));

	}

	public static void main(String[] args) {
		initialize();
		printing();
	}*/

}
