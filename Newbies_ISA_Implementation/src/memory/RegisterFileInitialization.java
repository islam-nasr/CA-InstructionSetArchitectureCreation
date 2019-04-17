package memory;

import java.util.HashMap;

public class RegisterFileInitialization {
	public static HashMap<String, Integer> regStrings = new HashMap<String, Integer>();
	
	public static void initialize() {
		String name = "$zero";
		regStrings.put(name, 0);

		name = "$one";
		regStrings.put(name, 1);

		name = "$sp";
		regStrings.put(name, 2);

		name = "$ra";
		regStrings.put(name, 3);

		name = "$s0";
		regStrings.put(name, 4);

		name = "$s1";
		regStrings.put(name, 5);

		name = "$s2";
		regStrings.put(name, 6);

		name = "$s3";
		regStrings.put(name, 7);

		name = "$t0";
		regStrings.put(name, 8);

		name = "$t1";
		regStrings.put(name, 9);
		
		name = "$t2";
		regStrings.put(name, 10);

		name = "$t3";
		regStrings.put(name, 11);

		name = "$a0";
		regStrings.put(name, 12);

		name = "$a1";
		regStrings.put(name, 13);

		name = "$a2";
		regStrings.put(name, 14);

		name = "$v0";
		regStrings.put(name, 15);
	}
}
