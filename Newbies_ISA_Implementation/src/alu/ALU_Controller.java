package alu;

import java.util.BitSet;

public class ALU_Controller {
	// add:
	// read opcode 0001 adds immediate with memory location
	// write opcode 0010 adds immediate with memory location
	// sum opcode 0011 adds 2 registers

	// subtract:
	// difference opcode 0100 subtracts 2 registers
	// SETMIN opcode 1011
	// SETMAX opcode 1100
	// SETLESSTHAN opcode 1101 (EDIT IN PROPOSAL OPCODE)
	// SKP opcode 1111 (subtract then checks if equal)

	// bitwise AND:
	// AND opcode 0101 ANDS 2 registers

	// bitwise OR:
	// OR opcode 0110 ORS 2 registers

	// bitwise NOT:
	// NOT opcode 0111 Negates one register

	// check alu Setlessthan

	// Shiftleftlogical:
	// SLL opcode 1110 using 2 ALU inputs
	/***
	 * 
	 * @param Opcode
	 *            to check the code entering to determine which operation to use
	 * @return operation code to go to the ALU
	 */
	public static String alucontrol(String Opcode) {
		switch (Opcode) {
		case "0001":
		case "0010":
		case "0011":
			return "000";// ADD OPCODE
		case "0100":
		case "1011":
		case "1100":
		case "1101":
		case "1111":
			return "001";// Subtract OPCODE
		case "0101":
			return "010";// BITWISE AND OPCODE
		case "0110":
			return "011";// BITWISE OR OPCODE
		case "0111":
			return "100";// BITWISE NOT OPCODE
		case "1110":
			return "101";// SHIFTLEFTLOGICAL
		default:
			return "111";// NOT ALU OPERATION
		}
	}

	public static String getBits(BitSet b) {
		String x = "";

		for (int i = 0; i < b.length(); i++) {
			x += b.get(i) ? "1" : "0";
		}
		return x;
	}

	public static BitSet toBits(String b) {
		BitSet r = new BitSet(b.length());

		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == 1)
				r.set(i, true);
		}
		return r;
	}

	/*
	 * public static void main(String[] args) { BitSet x = new BitSet(4); x.set(0);
	 * x.set(2); x.set(3); for (int i = 0; i < x.length(); i++) {
	 * System.out.println(x.get(i)); } System.out.println(x.toString());
	 * System.out.println(getBits(x)); }
	 */

}
