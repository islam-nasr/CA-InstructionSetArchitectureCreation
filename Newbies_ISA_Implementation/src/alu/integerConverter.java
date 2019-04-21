package alu;

public class integerConverter {
	public static int getTwosComplement(String binaryInt) {
		// Check if the number is negative.
		// We know it's negative if it starts with a 1
		if (binaryInt.charAt(0) == '1') {
			// Call our invert digits method
			String invertedInt = invertDigits(binaryInt);
			// Change this to decimal format.
			int decimalValue = Integer.parseInt(invertedInt, 2);
			// Add 1 to the current decimal and multiply it by -1
			// because we know it's a negative number
			decimalValue = (decimalValue + 1) * -1;
			// return the final result
			return decimalValue;
		} else {
			// Else we know it's a positive number, so just convert
			// the number to decimal base.
			return Integer.parseInt(binaryInt, 2);
		}
	}

	public static String artificialOR(int func, int rD, String imm) {
		String substring = Integer.toBinaryString(rD | func);
		while (substring.length() != 16) {
			substring = "0" + substring;
		}
		substring = substring.substring(0, substring.length() - 8) + imm;
		return substring;
	}

	private static String invertDigits(String binaryInt) {
		String result = binaryInt;
		result = result.replace("0", " "); // temp replace 0s
		result = result.replace("1", "0"); // replace 1s with 0s
		result = result.replace(" ", "1"); // put the 1s back in
		return result;
	}

	public static String toBinaryString(int number) {
		String result = "";
		int origin = Math.abs(number);

		while (origin > 0) {
			if (origin % 2 == 0)
				result = "0" + result;
			else
				result = "1" + result;
			origin = origin / 2;
		}
		while (result.length() < 16)
			result = "0" + result;

		if (number > 0)
			return result;
		else {
			String result2 = "";
			for (int i = 0; i < result.length(); i++)
				result2 += result.charAt(i) == '1' ? "0" : "1";
			char[] result2Array = result2.toCharArray();
			for (int i = result2Array.length - 1; i >= 0; i--)
				if (result2Array[i] == '0') {
					result2Array[i] = '1';
					break;
				} else
					result2Array[i] = '0';
			result2 = "";
			for (int i = 0; i < result2Array.length; i++)
				result2 += String.valueOf(result2Array[i]);
			return result2;
		}
	}

	// public static void main(String[] args) {
	// // System.out.println(Integer.toBinaryString(-3));
	// // System.out.println(Integer.toBinaryString(-3).substring(16).length());
	// // System.out.println(getTwosComplement(Integer.toBinaryString(-3)));
	// System.out.println(getTwosComplement(toBinaryString(100)));
	//
	// }
}
