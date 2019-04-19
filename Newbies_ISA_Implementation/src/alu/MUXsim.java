package alu;

public class MUXsim {
	/***
	 * 
	 * @param input0
	 *            first input at Entry point 0
	 * @param input1
	 *            2nd input at Entry point 1
	 * @param control
	 *            the control signal
	 * @return the signal that passed through
	 */
	public static String MUX(String input0, String input1, int control) {
		if (control == 1)
			return input1;
		else
			return input0;
	}
}
