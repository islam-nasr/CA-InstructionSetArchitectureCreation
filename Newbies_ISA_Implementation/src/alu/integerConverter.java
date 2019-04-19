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

	public static String invertDigits(String binaryInt) {
		String result = binaryInt;
		result = result.replace("0", " "); // temp replace 0s
		result = result.replace("1", "0"); // replace 1s with 0s
		result = result.replace(" ", "1"); // put the 1s back in
		return result;
	}
}
