package alu;

public class MUXsim {

	public static String MUX(String input0, String input1, int control) {
		if (control == 1)
			return input1;
		else
			return input0;
	}
}
