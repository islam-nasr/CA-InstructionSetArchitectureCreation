package memory;

import java.util.BitSet;

import alu.ALU_Controller;

public class ControlUnit {

	@SuppressWarnings("unused")
	public static void getControlSignals(BitSet opcode) {
		String OpcodeString = ALU_Controller.getBits(opcode);

		int regDst = 0;
		int regWrite = 0;
		int ra = 0;
		int PCSrc = 0;
		int memToReg = 0;
		int memRead = 0;
		int memWrite = 0;
		int not = 0;
		int ALUSrc = 0;
		int skip = 0;
		int max = 0;
		int min = 0;
		int setll = 0;

		switch (OpcodeString) {
		case "0000":
			regDst = 1;
			regWrite = 1;
			break;
		case "0001":
			regDst = 1;
			regWrite = 1;
			memRead = 1;
			memToReg = 1;
			break;
		case "0010":
		case "0011":
		case "0100":
		case "0101":
		case "0110":
			regDst = 1;
			regWrite = 1;
			break;
		case "0111":
			regDst = 1;
			regWrite = 1;
			not = 1;
			break;
		case "1000":
			ra = 1;
			PCSrc = 1;
			break;
		case "1001":
			PCSrc = 1;
			break;
		case "1010":
			PCSrc = 1;
			break;
		case "1011":
			min = 1;
			regDst = 1;
			regWrite = 1;
			break;
		case "1100":
			max = 1;
			regDst = 1;
			regWrite = 1;
			break; // check!!!
		case "1101":
			setll = 1;
			regWrite = 1;
			regDst = 1;
			break;
		case "1110":
			regDst = 1;
			regWrite = 1;
			break;
		case "1111":
			skip = 1;
			break;
		}
	}

}
