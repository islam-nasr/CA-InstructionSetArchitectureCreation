package alu;

public class MUXsim {

	public static String MUX(String input1, String input2, int control) {
		if (control == 1)
			return input1;
		else
			return input2;
	}
}