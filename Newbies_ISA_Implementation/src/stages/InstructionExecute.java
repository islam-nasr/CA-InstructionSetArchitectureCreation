package stages;

import alu.ALU;
import alu.ALU_Controller;
import alu.MUXsim;
import alu.integerConverter;
import memory.ControlUnit;

public class InstructionExecute extends Stage {
	private String result;
	private ControlUnit control;
	boolean isALU = true;
	boolean isEqual = false;
	int lastBit = 0;

	private int readData1;
	private int readData2;
	private String signExtend;
	private int writeRegisterNumber;

	public InstructionExecute(ControlUnit control, int readData1, int readData2, String signExtend,
			int writeRegisterNumber) {
		super();
		this.control = control;
		this.readData1 = readData1;
		this.readData2 = readData2;
		this.signExtend = signExtend;
		this.writeRegisterNumber = writeRegisterNumber;
	}

	public void execute() {
		System.out.println("==================================================================");
		System.out.println("Executing executing....");
		int ALUSrc = control.getALUSrc();
		int not = control.getNot();

		String ALUControl = ALU_Controller.getALUoperation(control.getOpcode());

		String first = MUXsim.MUX(integerConverter.toBinaryString(readData2), signExtend, ALUSrc);
		String second = MUXsim.MUX(first, "0000000000000000", not);
		System.out.println("First Wire:"+first+" "+integerConverter.getTwosComplement(first));
		System.out.println("Second Wire:"+second+" "+integerConverter.getTwosComplement(second));

		int secondint;
		ALU alu = new ALU();
		if (second.length() > 16)
			second = second.substring(16);
		if (second.charAt(0) == '1')
			secondint = integerConverter.getTwosComplement(second);
		else
			secondint = Integer.parseInt(second, 2);
		System.out.println("ReadData1: "+readData1);
		System.out.println("ReadData2: "+readData2);
		System.out.println("secondint: "+secondint);

		alu.operate(ALUControl, readData1, secondint);
		System.out.println(
				"First input to ALU: " + readData1 + '\n' + "Second input to ALU: " + Integer.parseInt(second, 2));
		lastBit = alu.lastBit();
		String ALUresult = integerConverter.toBinaryString(alu.getResult());
		System.out.println("ALURESULT STRING:"+ALUresult);
		System.out.println();
		System.out.println("Last bit: " + alu.lastBit());
		System.out.println("Result from ALU: " + integerConverter.getTwosComplement(ALUresult));
		this.result = MUXsim.MUX(ALUresult, signExtend, control.getLoadi());
		System.out.println("Output from Execution Stage: " + result + " int value is: "
				+ integerConverter.getTwosComplement(result));
	}

	public String getResult() {
		return result;
	}

	public ControlUnit getControl() {
		return control;
	}

	public int getReadData1() {
		return readData1;
	}

	public int getReadData2() {
		return readData2;
	}

	public int getWriteRegisterNumber() {
		return writeRegisterNumber;
	}

	public int getLastBit() {
		return lastBit;
	}

}
