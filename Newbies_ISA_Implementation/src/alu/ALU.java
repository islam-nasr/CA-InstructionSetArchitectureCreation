package alu;

public class ALU {
	int result;
	boolean isALU = true;
	boolean isEqual = false;
	int lastbit = 0;

	/***
	 * 
	 * @param Opcode value entering the ALU to determine which operator to use
	 * @param value1 first operand
	 * @param value2 second operand
	 * @return result of the operation
	 */
	public int operate(String Opcode, int value1, int value2) {
		switch (Opcode) {
		case "000":
			result = value1 + value2;
			break;// call add method
		case "001":
			result = value1 - value2;
			isEqual = true;
			break;// subtract
		case "010":
			result = value1 & value2;
			break;// and
		case "011":
			result = value1 | value2;
			break;// or
		case "100":
			result = ~value1;
			break;// not
		case "101":
			result = (value1 << value2);
			break;// SLL
		default:
			isALU = false;
			result = 0;
			break;// notALU

		}
		if (result < 0) {
			lastbit = 1;
		}
		return result;

	}

	public int getResult() {
		return result;
	}

	public boolean isALU() {
		return isALU;
	}

	public boolean isEqual() {
		return isEqual;
	}

	public int lastBit() {
		return lastbit;
	}

}
