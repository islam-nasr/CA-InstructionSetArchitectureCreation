package memory;

import java.util.HashMap;

public class RegisterFileInitialization {
	public static HashMap<String, Integer> regStrings = new HashMap<String, Integer>();
	public static HashMap<String, Integer> positionStrings = new HashMap<String, Integer>();

	public static void initialize() {
		String name = "$zero";
		regStrings.put(name, 0);
		positionStrings.put("0000", 0);
		name = "$one";
		regStrings.put(name, 1);
		positionStrings.put("0001", 1);

		name = "$sp";
		regStrings.put(name, 2);
		positionStrings.put("0010", 2);

		name = "$ra";
		regStrings.put(name, 3);
		positionStrings.put("0011", 3);

		name = "$s0";
		regStrings.put(name, 4);
		positionStrings.put("0100", 4);

		name = "$s1";
		regStrings.put(name, 5);
		positionStrings.put("0101", 5);

		name = "$s2";
		regStrings.put(name, 6);
		positionStrings.put("0110", 6);

		name = "$s3";
		regStrings.put(name, 7);
		positionStrings.put("0111", 7);

		name = "$t0";
		regStrings.put(name, 8);
		positionStrings.put("1000", 8);

		name = "$t1";
		regStrings.put(name, 9);
		positionStrings.put("1001", 9);

		name = "$t2";
		regStrings.put(name, 10);
		positionStrings.put("1010", 10);

		name = "$t3";
		regStrings.put(name, 11);
		positionStrings.put("1011", 11);

		name = "$a0";
		regStrings.put(name, 12);
		positionStrings.put("1100", 12);

		name = "$a1";
		regStrings.put(name, 13);
		positionStrings.put("1101", 13);

		name = "$a2";
		regStrings.put(name, 14);
		positionStrings.put("1110", 14);

		name = "$v0";
		regStrings.put(name, 15);
		positionStrings.put("1111", 15);

	}
}
