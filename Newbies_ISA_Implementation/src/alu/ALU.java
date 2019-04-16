package alu;

import java.util.BitSet;

public class ALU {

	public static int Operation(BitSet Opcode, int value1, int value2) {
		String OpcodeString = ALU_Controller.getBits(Opcode);
		int result;
		boolean isALU=true;
		boolean isEqual=false;
		boolean lastbit=false;
		switch (OpcodeString) {
		case "000":
			result = value1 + value2;break;// call add method
		case "001":
			result = value1 - value2;isEqual=true;break;// subtract
		case "010":
			result = value1 & value2;break;// and
		case "011":
			result = value1 | value2;break;// or
		case "100":
			result = ~value1;break;// not
		case "101":
			result = (value1 << value2);break;// SLL
		default:
			isALU = false;result=0;break;// notALU

		}
		if(result<0) {
			lastbit=true;
		}
		return result;
		
	}
}
