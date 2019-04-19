package stages;

import memory.ControlUnit;
import java.util.HashMap;
import alu.MUXsim;
import memory.RegisterFileInitialization;
import memory.RegisterFile;

public class InstructionsDecoding {
	static int readData1;
	static int readData2;
	static String signExtend;
	static int writeRegisterNumber;

	public static void Decode(String instruction, ControlUnit control) {
		String readRegister2 = instruction.substring(instruction.length() - 4, instruction.length());
		String readRegister1 = instruction.substring(instruction.length() - 8, instruction.length() - 4);
		String rD = instruction.substring(instruction.length() - 12, instruction.length() - 8);
		String writeRegister = MUXsim.MUX(readRegister2, rD, control.getRegDst());
		HashMap<String, Integer> positionStrings = RegisterFileInitialization.positionStrings;
		int registerNumber1 = positionStrings.get(readRegister1).intValue();
		int registerNumber2 = positionStrings.get(readRegister2).intValue();
		writeRegisterNumber = positionStrings.get(writeRegister).intValue();
		readData1 = RegisterFile.readRegisterValue(registerNumber1);
		readData2 = RegisterFile.readRegisterValue(registerNumber2);
		signExtend = instruction.substring(instruction.length() - 8, instruction.length());
		boolean positive = true;
		if (signExtend.charAt(0) == '1') {
			positive = false;
		}
		while (signExtend.length() < 16) {
			if (positive)
				signExtend = "0" + signExtend;
			else
				signExtend = "1" + signExtend;

		}

	}

	public static int getReadData1() {
		return readData1;
	}

	public static int getReadData2() {
		return readData2;
	}

	public static String getSignExtend() {
		return signExtend;
	}

	public static int getWriteRegisterNumber() {
		return writeRegisterNumber;
	}

}
