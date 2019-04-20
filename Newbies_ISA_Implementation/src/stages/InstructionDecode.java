package stages;

import java.util.HashMap;

import alu.MUXsim;
import memory.ControlUnit;
import memory.RegisterFile;
import memory.RegisterFileInitialization;

public class InstructionDecode extends Stage {
	int readData1;
	int readData2;
	String signExtend;
	int writeRegisterNumber;
	String instruction;
	ControlUnit control;

	// public InstructionDecode() {
	// super();
	// }

	public InstructionDecode(String instruction, ControlUnit control) {
		super();
		this.instruction = instruction;
		this.control = control;
	}

	public void execute() {
		System.out.println("==================================================================");
		System.out.println("Executing decoding....");
		RegisterFile.toPrint();
		String readRegister2 = instruction.substring(instruction.length() - 4, instruction.length());
		String readRegister1 = instruction.substring(instruction.length() - 8, instruction.length() - 4);
		String rD = instruction.substring(instruction.length() - 12, instruction.length() - 8);
		System.out.print(
				"Register Code:" + '\n' + "RD: " + rD + " RS: " + readRegister1 + " RT: " + readRegister2 + '\n');
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
		this.toPrint();

	}

	public int getReadData1() {
		return readData1;
	}

	public int getReadData2() {
		return readData2;
	}

	public String getSignExtend() {
		return signExtend;
	}

	public int getWriteRegisterNumber() {
		return writeRegisterNumber;
	}

	public ControlUnit getControl() {
		return control;
	}

	public void toPrint() {
		// TODO Auto-generated method stub
		System.out.print("Data output:" + '\n' + "ReadData1: " + readData1 + " ReadData2: " + readData2
				+ " Sign Extend: " + signExtend + " WriteRegister: " + writeRegisterNumber + '\n');
	}
	/*
	 * public void execute() { System.out.println("Executing decoding......"); }
	 */

}
