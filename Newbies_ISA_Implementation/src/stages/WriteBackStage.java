package stages;

import alu.MUXsim;
import alu.integerConverter;
import memory.ControlUnit;
import memory.DataMemory;
import memory.RegisterFile;

public class WriteBackStage extends Stage {
	ControlUnit control;
	String result;
	int writeRegisterNumber;
	int readData;
	int readData1;
	int readData2;
	int fifteenthBit;
	int writeBackValue;
	// processes.add(i, new WriteBackStage(cpu, writeRegisterNumber, result,
	// readData, readData1, readData2, fifteenthBit));

	public WriteBackStage(ControlUnit control, int writeRegisterNumber, String result, int readData, int readData1,
			int readData2, int fifteenthBit) {
		super();
		this.writeRegisterNumber = writeRegisterNumber;
		this.readData = readData;
		this.readData1 = readData1;
		this.readData2 = readData2;
		this.fifteenthBit = fifteenthBit;
		this.control = control;
		this.result = result;
	}

	public void execute() {
		System.out.println("==================================================================");
		System.out.println("Executing WriteBackStage....");
		System.out.println("ReadData1 "+readData1);
		System.out.println("ReadData2 "+readData2);
		String w1 = MUXsim.MUX(integerConverter.toBinaryString(readData1), integerConverter.toBinaryString(readData2), control.getMin());
		String w2 = MUXsim.MUX(integerConverter.toBinaryString(readData1), integerConverter.toBinaryString(readData2), control.getMax());
		String out = MUXsim.MUX(w1, w2, fifteenthBit);
		System.out.println(
				"Wire 1 value: " + w1 + '\n' + "Wire 2 value: " + w2 + '\n' + "Output of 2 wires Value: " + out);
		String fifteenthBitString;
		if (fifteenthBit == 0)
			fifteenthBitString = "0000000000000000";
		else
			fifteenthBitString = "0000000000000001";

		String out2 = MUXsim.MUX(out, fifteenthBitString, control.getSetll());
		String out1 = MUXsim.MUX(result, Integer.toBinaryString(readData), control.getMemToReg());

		String finalOutput = MUXsim.MUX(out1, out2, control.getCreative());
		writeBackValue = integerConverter.getTwosComplement(finalOutput);
		System.out.println("Write Back Value: " + writeBackValue + '\n' + "Final Output Value: " + finalOutput);
		RegisterFile.writeRegister(writeRegisterNumber, writeBackValue);
		RegisterFile.toPrint();
		DataMemory.toPrint();

	}

}
