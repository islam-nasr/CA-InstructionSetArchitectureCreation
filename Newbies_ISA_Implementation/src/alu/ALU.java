package alu;

import memory.ControlUnit;
import simulation.Simulator;

public class ALU {
	int result;
	boolean isALU = true;
	boolean isEqual = false;
	int lastbit = 0;

	/***
	 * Tells the ALU to operate, setting the instance variables of this ALU
	 * 
	 * @param Opcode
	 *            value entering the ALU to determine which operator to use
	 * @param value1
	 *            first operand
	 * @param value2
	 *            second operand
	 * @return result of the operation
	 */
	public int operate(String Opcode, int value1, int value2) {
		switch (Opcode) {
		case "000":
			result = value1 + value2;
			System.out.println(value1);
			System.out.println(value2);
			System.out.println(result);
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
			System.out.println("CASE SHIFT:" + "Value1: " + value1 + '\n' + "Value2:" + value2);
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

	/***
	 * Represents the adder that's at the top right corner of the datapath
	 * 
	 * @param signExtend
	 *            the first value entering, which is the signExtend
	 * @param returnAddress
	 *            the second input which is readData1 from the data path
	 * @param control
	 *            the control unit to use some of the signals of it
	 * @return result of the addition
	 */
	public static int adder(String signExtend, int returnAddress, ControlUnit control) {
		signExtend = signExtend.substring(1);
		signExtend = signExtend + "0";
		String ra = integerConverter.toBinaryString(returnAddress);
		String adderInput = MUXsim.MUX(ra, signExtend, control.getRa());
		return (Integer.parseInt(adderInput, 2) + Simulator.PC.getValue());

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
