package memory;

public class ControlUnit {
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
	int creative = 0;
	int Loadi = 0;
	String opcode = "XXXX";

	public void setControlSignals(String opcode) {
		this.opcode = opcode;

		switch (opcode) {
		case "0000":
			regDst = 1;
			regWrite = 1;
			Loadi = 1;
			break;
		case "0001":
			regDst = 1;
			regWrite = 1;
			memRead = 1;
			memToReg = 1;
			break;
		case "0010":
			regDst = 1;
			memWrite = 1;
			break;
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
			ra = 1;
			PCSrc = 1;
			break;
		case "1011":
			creative = 1;
			min = 1;
			regDst = 1;
			regWrite = 1;
			break;
		case "1100":
			creative = 1;
			max = 1;
			regDst = 1;
			regWrite = 1;
			break; // check!!!
		case "1101":
			creative = 1;
			setll = 1;
			regWrite = 1;
			regDst = 1;
			break;
		case "1110":
			ALUSrc = 1;
			regDst = 1;
			regWrite = 1;
			break;
		case "1111":
			skip = 1;
			break;
		}
	}

	public int getLoadi() {
		return Loadi;
	}

	public int getRegDst() {
		return regDst;
	}

	public int getRegWrite() {
		return regWrite;
	}

	public int getRa() {
		return ra;
	}

	public int getPCSrc() {
		return PCSrc;
	}

	public int getMemToReg() {
		return memToReg;
	}

	public int getMemRead() {
		return memRead;
	}

	public int getMemWrite() {
		return memWrite;
	}

	public int getNot() {
		return not;
	}

	public int getALUSrc() {
		return ALUSrc;
	}

	public int getSkip() {
		return skip;
	}

	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}

	public int getSetll() {
		return setll;
	}

	public int getCreative() {
		return creative;
	}

	public String getOpcode() {
		return opcode;
	}

	public void toPrint() {
		System.out.println("Control Unit being printed!");
		System.out.println("RegDst -------> " + regDst);
		System.out.println("RegWrite -----> " + regWrite);
		System.out.println("RA -----------> " + ra);
		System.out.println("PCSrc --------> " + PCSrc);
		System.out.println("MemToReg -----> " + memToReg);
		System.out.println("MemToRead ----> " + memRead);
		System.out.println("MemWrite -----> " + memWrite);
		System.out.println("Not ----------> " + not);
		System.out.println("ALUSrc -------> " + ALUSrc);
		System.out.println("Skip ---------> " + skip);
		System.out.println("Max ----------> " + max);
		System.out.println("Min ----------> " + min);
		System.out.println("SetLessThan --> " + setll);
		System.out.println("Creative -----> " + creative);
		System.out.println("Loadi --------> " + Loadi);
		System.out.println("==================================================================");
	}

}
